package com.project.HMF.Dto.res;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommonLoginResDto {

    private Integer userId;
    private String userFName;
    private String userLName;
    private String userMobileNo;
    private String userReferenceMobileNo;
    private String userStatus;

    private Integer vendorId;
    private String vendorFName;
    private String vendorLName;
    private String vendorMobileNo;
    private String vendorBusinessMobileNo;
    private String vendorReferenceMobileNo;
    private String vendorBusinessName;
    private String vendorBusinessImage;
    private String vendorBusinessAddress;
    private String vendorBusinessProof;
    private Date subscriptionStartDate;
    private Date subscriptionEndDate;
    private String vendorStatus;

    private Integer subscriptionId;
    private String subscriptionName;

    private Integer categoryId;
    private String categoryName;

    //extra
    private String registrationType;
    private Integer responseCode;
    private String message;
}
