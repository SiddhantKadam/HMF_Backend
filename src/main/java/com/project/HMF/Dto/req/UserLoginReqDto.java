package com.project.HMF.Dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginReqDto {

    private String userMobileNo;
    private String userPassword;
}
