package com.project.HMF.Service.impl;

import com.project.HMF.Dao.UserDao;
import com.project.HMF.Dao.VendorDao;
import com.project.HMF.Dto.req.CommonLoginReqDto;
import com.project.HMF.Dto.res.CommonLoginResDto;
import com.project.HMF.Dto.res.UserLoginResDto;
import com.project.HMF.Dto.res.VendorLoginResDto;
import com.project.HMF.Model.UserMaster;
import com.project.HMF.Model.VendorMaster;
import com.project.HMF.Service.CommonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private VendorDao vendorDao;

    @Override
    public CommonLoginResDto commonLogin(CommonLoginReqDto commonLoginReqDto) {

        CommonLoginResDto commonLoginResDto = new CommonLoginResDto();
        UserMaster userMaster = userDao.findAllByUserMobileNo(commonLoginReqDto.getMobileNo());
        VendorMaster vendorMaster = vendorDao.findAllByVendorMobileNo(commonLoginReqDto.getMobileNo());

        if (userMaster != null) {
            if (userMaster.getUserPassword().equals(commonLoginReqDto.getPassword())) {
                if (userMaster.getUserStatus().equals("Active")) {

                    commonLoginResDto.setResponseCode(HttpStatus.OK.value());
                    commonLoginResDto.setMessage("Login Success");
                    commonLoginResDto.setRegistrationType(userMaster.getRegistrationType());
                    commonLoginResDto.setUserId(userMaster.getUserId());
                    commonLoginResDto.setUserFName(userMaster.getUserFName());
                    commonLoginResDto.setUserLName(userMaster.getUserLName());
                    commonLoginResDto.setUserMobileNo(userMaster.getUserMobileNo());
                    commonLoginResDto.setUserReferenceMobileNo(userMaster.getUserReferenceMobileNo());
                    commonLoginResDto.setUserStatus(userMaster.getUserStatus());
//                    BeanUtils.copyProperties(userMaster, userLoginResDto);

                } else {
                    commonLoginResDto.setResponseCode(HttpStatus.FORBIDDEN.value());
                    commonLoginResDto.setMessage("Account Has Been Blocked");
                }
            } else {
                commonLoginResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
                commonLoginResDto.setMessage("Password Is Invalid");
            }
        } else if (vendorMaster != null) {
            if (vendorMaster.getVendorPassword().equals(commonLoginReqDto.getPassword())) {

                commonLoginResDto.setResponseCode(HttpStatus.OK.value());
                commonLoginResDto.setMessage("Login Success");

                commonLoginResDto.setVendorId(vendorMaster.getVendorId());
                commonLoginResDto.setVendorFName(vendorMaster.getVendorFName());
                commonLoginResDto.setVendorLName(vendorMaster.getVendorLName());
                commonLoginResDto.setVendorMobileNo(vendorMaster.getVendorMobileNo());
                commonLoginResDto.setVendorStatus(vendorMaster.getVendorStatus());
                commonLoginResDto.setRegistrationType(vendorMaster.getRegistrationType());

                commonLoginResDto.setVendorBusinessName(vendorMaster.getVendorBusinessName());
                commonLoginResDto.setVendorBusinessMobileNo(vendorMaster.getVendorBusinessMobileNo());
                commonLoginResDto.setVendorReferenceMobileNo(vendorMaster.getVendorReferenceMobileNo());
                commonLoginResDto.setVendorBusinessAddress(vendorMaster.getVendorBusinessAddress());
                commonLoginResDto.setVendorBusinessProof(vendorMaster.getVendorBusinessProof());
                commonLoginResDto.setVendorBusinessImage(vendorMaster.getVendorBusinessImage());

                commonLoginResDto.setSubscriptionStartDate(vendorMaster.getSubscriptionStartDate());
                commonLoginResDto.setSubscriptionEndDate(vendorMaster.getSubscriptionEndDate());
//                    BeanUtils.copyProperties(vendorMaster, vendorLoginResDto);
                if (vendorMaster.getSubscriptionMaster() != null) {
                    commonLoginResDto.setSubscriptionId(vendorMaster.getSubscriptionMaster().getSubscriptionId());
                    commonLoginResDto.setSubscriptionName(vendorMaster.getSubscriptionMaster().getSubscriptionName());
                }
                if (vendorMaster.getCategoryMaster() != null) {
                    commonLoginResDto.setCategoryId(vendorMaster.getCategoryMaster().getCategoryId());
                    commonLoginResDto.setCategoryName(vendorMaster.getCategoryMaster().getCategoryName());
                }
            } else {
                commonLoginResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
                commonLoginResDto.setMessage("Password Is Invalid");
            }
        } else if (userMaster == null) {
            commonLoginResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            commonLoginResDto.setMessage("Mobile number not exist");
        } else if (vendorMaster == null) {
            commonLoginResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            commonLoginResDto.setMessage("Mobile number not exist");
        }

        return commonLoginResDto;
    }
}
