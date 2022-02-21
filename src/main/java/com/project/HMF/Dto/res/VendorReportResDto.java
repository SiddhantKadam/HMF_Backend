package com.project.HMF.Dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class VendorReportResDto {

    private Integer vendorId;
    private String vendorFName;
    private String vendorLName;
    private String vendorMobileNo;
    private String vendorBusinessMobileNo;
    private String vendorReferenceMobileNo;
    private String vendorBusinessName;
    private String vendorBusinessImage;
    private String vendorBusinessAddress;
    private String vendorStatus;
    private Date vendorRegistrationDate;
    private String categoryName;
//    private Integer categoryId;
//    private String categoryName;

}
