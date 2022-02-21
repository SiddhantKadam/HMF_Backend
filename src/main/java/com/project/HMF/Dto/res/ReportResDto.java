package com.project.HMF.Dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ReportResDto {

    private Integer userId;
    private String userFName;
    private String userLName;
    private String userMobileNo;
    private Date registrationDate;
    private String userStatus;

}
