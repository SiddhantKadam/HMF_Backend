package com.project.HMF.Service;

import com.project.HMF.Dto.req.ReportReqDto;
import com.project.HMF.Dto.req.UserLoginReqDto;
import com.project.HMF.Dto.req.UserValidateOtpReqDto;
import com.project.HMF.Dto.res.UserForgotResDto;
import com.project.HMF.Dto.res.UserLoginResDto;
import com.project.HMF.Dto.res.UserRegistrationResDto;
import com.project.HMF.Model.UserMaster;

import java.util.List;

public interface UserService {
    UserRegistrationResDto create(UserMaster userMaster);

    UserLoginResDto userLogin(UserLoginReqDto userLoginReqDto);

    List getAllUser();

    UserMaster getUserById(Integer userId);

    UserRegistrationResDto update(UserMaster userMaster);

    Boolean updatePassword(Integer userId, String password);

    UserForgotResDto userForgotPassword(String userMobileNo);

    List getUserReporFromToDate(ReportReqDto reportReqDto);

    List getActiveUser();

    boolean validateOtp(UserValidateOtpReqDto userValidateOtpReqDto);
}
