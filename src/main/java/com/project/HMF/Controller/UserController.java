package com.project.HMF.Controller;

import com.project.HMF.Dto.req.*;
import com.project.HMF.Dto.res.CommonLoginResDto;
import com.project.HMF.Dto.res.UserForgotResDto;
import com.project.HMF.Dto.res.UserLoginResDto;
import com.project.HMF.Dto.res.UserRegistrationResDto;
import com.project.HMF.Model.BannerMaster;
import com.project.HMF.Model.UserMaster;
import com.project.HMF.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private ResponseEntity create(@RequestBody UserMaster userMaster){
        UserRegistrationResDto userRegistrationResDto = userService.create(userMaster);
        return new ResponseEntity(userRegistrationResDto, HttpStatus.CREATED);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody UserMaster userMaster){
        UserRegistrationResDto userRegistrationResDto = userService.update(userMaster);
        return new ResponseEntity(userRegistrationResDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/userLogin")
    public ResponseEntity userLogin(@RequestBody UserLoginReqDto userLoginReqDto)
    {
        UserLoginResDto userLoginResDto = userService.userLogin(userLoginReqDto);
        return new ResponseEntity(userLoginResDto, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity getAllUser() {
        List list = userService.getAllUser();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/activeUser")
    private ResponseEntity getActiveUser() {
        List list = userService.getActiveUser();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/getById/{userId}")
    private ResponseEntity getUserById(@PathVariable Integer userId) {
        UserMaster userMaster = userService.getUserById(userId);
        if (userMaster != null) {
            return new ResponseEntity(userMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity(userMaster, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/changePassword/{userId}/{password}")
    private ResponseEntity userChangePassword(@PathVariable Integer userId, @PathVariable String password) {
        Boolean flag = userService.updatePassword(userId, password);
        return new ResponseEntity(flag, HttpStatus.CREATED);
    }

    @GetMapping(value = "/userForgotPassword/{userMobileNo}")
    public ResponseEntity userForgotPassword(@PathVariable String userMobileNo)
    {
        UserForgotResDto userForgotPassword = userService.userForgotPassword(userMobileNo);
        return new ResponseEntity(userForgotPassword,HttpStatus.OK);
    }

    @PostMapping(value = "/validateUserOtp")
    public ResponseEntity validateOtp(@RequestBody UserValidateOtpReqDto userValidateOtpReqDto)
    {
        boolean flag = userService.validateOtp(userValidateOtpReqDto);
        return new ResponseEntity(flag,HttpStatus.OK);
    }

    @PostMapping(value = "/getReportFromToDate")
    private ResponseEntity getReportListFromToDate(@RequestBody ReportReqDto reportReqDto)
    {
        List list= userService.getUserReporFromToDate(reportReqDto);

        return new ResponseEntity(list, HttpStatus.OK);
    }

}
