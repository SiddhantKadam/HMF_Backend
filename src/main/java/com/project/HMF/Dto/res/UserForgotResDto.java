package com.project.HMF.Dto.res;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserForgotResDto {
    private Integer userId;
    private Boolean status;
}
