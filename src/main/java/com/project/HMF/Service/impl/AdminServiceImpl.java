package com.project.HMF.Service.impl;

import com.project.HMF.Dao.AdminDao;
import com.project.HMF.Dao.UserDao;
import com.project.HMF.Dto.req.AdminLoginReqDto;
import com.project.HMF.Dto.res.AdminLoginResDto;
import com.project.HMF.Model.AdminSetting;
import com.project.HMF.Model.UserMaster;
import com.project.HMF.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public AdminLoginResDto adminLogin(AdminLoginReqDto adminLoginReqDto) {
        AdminLoginResDto adminLoginResDto = new AdminLoginResDto();
        AdminSetting adminSetting1 = adminDao.findAllByAdminMobileNo(adminLoginReqDto.getAdminMobileNo());
        if (adminSetting1 != null) {
            if (adminSetting1.getAdminPassword().equals(adminLoginReqDto.getAdminPassword())) {
                adminLoginResDto.setAdminId(adminSetting1.getAdminId());
                adminLoginResDto.setResponseCode(HttpStatus.OK.value());
                adminLoginResDto.setMessage("Login Success");
            } else {
                adminLoginResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
                adminLoginResDto.setMessage("Password Is Invalid");
            }
        } else {
            adminLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            adminLoginResDto.setMessage("Mobile Number is Not Found");
        }
        return adminLoginResDto;
    }

    @Override
    public Boolean updateAdmin(AdminSetting adminSetting) {
        try {
            adminSetting.setAdminStatus("Active");
            adminDao.save(adminSetting);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public AdminSetting getAdminById(Integer adminId) {
        AdminSetting adminSetting = new AdminSetting();
        try {
            adminSetting = adminDao.findOne(adminId);
            return adminSetting;
        } catch (Exception e) {
            e.printStackTrace();
            return adminSetting;
        }
    }
}

