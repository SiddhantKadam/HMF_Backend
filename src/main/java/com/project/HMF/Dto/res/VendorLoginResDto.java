package com.project.HMF.Dto.res;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class VendorLoginResDto {

    private Integer vendorId;
    private String vendorFName;
    private String vendorLName;
    private String vendorMobileNo;
    private String vendorBusinessName;
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

    //extra
    private Integer responseCode;
    private String message;
}
