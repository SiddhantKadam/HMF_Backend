package com.project.HMF.Dto.res;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class VendorLoginResDto {

    private Integer vendorId;
    private String vendorFName;
    private String vendorLName;
    private String vendorMobileNo;
    private String vendorPassword;
    private String vendorBusinessName;
    private String vendorBusinessCategory;
    private String vendorBusinessAddress;
    private String vendorBusinessProof;

    //extra
    private Integer responseCode;
    private String message;
}
