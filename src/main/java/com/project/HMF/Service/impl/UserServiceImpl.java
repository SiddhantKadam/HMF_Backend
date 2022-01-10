package com.project.HMF.Service.impl;

import com.project.HMF.Dao.UserDao;
import com.project.HMF.Dao.VendorDao;
import com.project.HMF.Dto.req.UserLoginReqDto;
import com.project.HMF.Dto.res.UserLoginResDto;
import com.project.HMF.Dto.res.UserRegistrationResDto;
import com.project.HMF.Dto.res.VendorRegistrationResDto;
import com.project.HMF.Model.BannerMaster;
import com.project.HMF.Model.UserMaster;
import com.project.HMF.Model.VendorMaster;
import com.project.HMF.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private VendorDao vendorDao;

    @Override
    public UserRegistrationResDto create(UserMaster userMaster) {

        UserRegistrationResDto userRegistrationResDto = new UserRegistrationResDto();
        UserMaster userMaster1 = userDao.findOneByUserMobileNo(userMaster.getUserMobileNo());
        VendorMaster vendorMaster1 = vendorDao.findOneByVendorMobileNo(userMaster.getUserMobileNo());
        if (userMaster1 == null && vendorMaster1 == null) {
            try {
                userMaster.setUserStatus("Active");
                userDao.save(userMaster);
                userRegistrationResDto.setMessage("Save Succesfully");
                userRegistrationResDto.setUserId(userMaster.getUserId());
                userRegistrationResDto.setUserFName(userMaster.getUserFName());
                userRegistrationResDto.setUserLName(userMaster.getUserLName());
                userRegistrationResDto.setUserMobileNo(userMaster.getUserMobileNo());
                userRegistrationResDto.setRegistrationType(userMaster.getRegistrationType());
                userRegistrationResDto.setUserStatus(userMaster.getUserStatus());
            } catch (Exception e) {
                e.printStackTrace();
                userRegistrationResDto.setMessage("Failed");
            }
        } else {
            userRegistrationResDto.setMessage("Mobile No Already Exist");
        }
        return userRegistrationResDto;
    }

    @Override
    public UserLoginResDto userLogin(UserLoginReqDto userLoginReqDto) {
        UserMaster userMaster = userDao.findAllByUserMobileNo(userLoginReqDto.getUserMobileNo());
        UserLoginResDto userLoginResDto = new UserLoginResDto();
        if (userMaster != null) {
            if (userMaster.getUserPassword().equals(userLoginReqDto.getUserPassword())) {
                if (userMaster.getUserStatus().equals("Active")) {

                    userLoginResDto.setResponseCode(HttpStatus.OK.value());
                    userLoginResDto.setMessage("Login Success");
                    BeanUtils.copyProperties(userMaster, userLoginResDto);

                } else {
                    userLoginResDto.setResponseCode(HttpStatus.FORBIDDEN.value());
                    userLoginResDto.setMessage("Account Has Been Blocked");
                }
            } else {
                userLoginResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
                userLoginResDto.setMessage("Password Is Invalid");
            }
        }
        if (userMaster == null) {
            userLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            userLoginResDto.setMessage("Mobile Number is Not Found");
        } else if (!userMaster.getUserMobileNo().equals(userLoginReqDto.getUserMobileNo())) {
            System.out.println("Mobile No is not equal");
            userLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            userLoginResDto.setMessage("Mobile Number is Not Found");
        }
        return userLoginResDto;
    }

    @Override
    public List getAllUser() {
        return (List) userDao.findAll();
    }

    @Override
    public UserMaster getUserById(Integer userId) {
        UserMaster userMaster = new UserMaster();
        try {
            userMaster = userDao.findOne(userId);
            return userMaster;
        } catch (Exception e) {
            e.printStackTrace();
            return userMaster;
        }
    }

    @Override
    public UserRegistrationResDto update(UserMaster userMaster) {
        UserRegistrationResDto userRegistrationResDto = new UserRegistrationResDto();
        try {
            userDao.save(userMaster);
            userRegistrationResDto.setMessage("Update Succesfully");
        } catch (Exception e) {
            e.printStackTrace();
            userRegistrationResDto.setMessage("Failed");
        }
        return userRegistrationResDto;
    }

    @Override
    public Boolean updatePassword(Integer userId, String password) {
        Integer flag = userDao.updatePassword(userId, password);
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean userForgotPassword(String userMobileNo) {
        UserMaster userMaster1 = userDao.findOneByUserMobileNo(userMobileNo);
        if (userMaster1 == null) {
            System.out.println("OTP False");
            return false;
        } else {
            System.out.println("OTP True");
            return true;
        }
    }
}
