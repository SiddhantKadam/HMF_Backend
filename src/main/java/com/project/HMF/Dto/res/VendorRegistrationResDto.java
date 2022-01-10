package com.project.HMF.Dto.res;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VendorRegistrationResDto {

    private Integer vendorId;
    private String vendorFName;
    private String vendorLName;
    private String vendorMobileNo;
    private String vendorBusinessName;
    private String vendorBusinessImage;
    private String vendorBusinessCategory;
    private String vendorBusinessAddress;
    private String vendorBusinessProof;
    private String registrationType;
    private Date subscriptionStartDate;
    private Date subscriptionEndDate;
    private String vendorStatus;

    private Integer subscriptionId;
    private String subscriptionName;

    private Integer categoryId;
    private String categoryName;

    private String message;

}
