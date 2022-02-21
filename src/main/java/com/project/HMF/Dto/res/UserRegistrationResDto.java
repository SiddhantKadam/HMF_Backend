package com.project.HMF.Dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationResDto {

    private Integer userId;
    private String userFName;
    private String userLName;
    private String userMobileNo;
    private String userReferenceMobileNo;
    private String registrationType;
    private String userStatus;

    private String message;
}
