package com.project.HMF.Dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommonLoginReqDto {

    private String mobileNo;
    private String password;
}
