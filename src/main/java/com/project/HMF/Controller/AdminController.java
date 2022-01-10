package com.project.HMF.Controller;

import com.project.HMF.Dto.req.AdminLoginReqDto;
import com.project.HMF.Dto.req.UserLoginReqDto;
import com.project.HMF.Dto.res.AdminLoginResDto;
import com.project.HMF.Dto.res.UserLoginResDto;
import com.project.HMF.Model.AdminSetting;
import com.project.HMF.Model.BannerMaster;
import com.project.HMF.Service.AdminService;
import com.project.HMF.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/admin-setting")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/adminLogin")
    public ResponseEntity adminLogin(@RequestBody AdminLoginReqDto adminLoginReqDto)
    {
        AdminLoginResDto adminLoginResDto = adminService.adminLogin(adminLoginReqDto);
        return new ResponseEntity(adminLoginResDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateAdmin(@RequestBody AdminSetting adminSetting)
    {
        Boolean flag = adminService.updateAdmin(adminSetting);
        return new ResponseEntity(flag, HttpStatus.OK);
    }

    @GetMapping(value = "/getById/{adminId}")
    private ResponseEntity getAdminById(@PathVariable Integer adminId) {
        AdminSetting adminSetting = adminService.getAdminById(adminId);
        if (adminSetting != null) {
            return new ResponseEntity(adminSetting, HttpStatus.OK);
        } else {
            return new ResponseEntity(adminSetting, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
