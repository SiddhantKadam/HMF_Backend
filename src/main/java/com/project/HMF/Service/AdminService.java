package com.project.HMF.Service;

import com.project.HMF.Dto.req.AdminLoginReqDto;
import com.project.HMF.Dto.res.AdminLoginResDto;
import com.project.HMF.Model.AdminSetting;

public interface AdminService {
    AdminLoginResDto adminLogin(AdminLoginReqDto adminLoginReqDto);

    Boolean updateAdmin(AdminSetting adminSetting);

    AdminSetting getAdminById(Integer adminId);
}
