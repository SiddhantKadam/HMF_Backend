package com.project.HMF.Dto.res;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class UserLoginResDto {

    private Integer userId;
    private String userFName;
    private String userLName;
    private String userMobileNo;
    private String userReferenceMobileNo;
    private String registrationType;
    private String userStatus;

    //extra
    private Integer responseCode;
    private String message;

}
