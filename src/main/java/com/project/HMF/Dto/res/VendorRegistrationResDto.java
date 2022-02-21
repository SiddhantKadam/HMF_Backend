package com.project.HMF.Dto.res;

import com.project.HMF.Model.VendorImages;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class VendorRegistrationResDto {

    private Integer vendorId;
    private String vendorFName;
    private String vendorLName;
    private String vendorMobileNo;
    private String vendorBusinessMobileNo;
    private String vendorReferenceMobileNo;
    private String vendorBusinessName;
    private String vendorBusinessImage;
    private String vendorBusinessCategory;
    private String vendorBusinessAddress;
    private String vendorBusinessProof;
    private String vendorOpeningTime;
    private String vendorClosingTime;
    private String vendorHoliday;
    private String registrationType;
    private Date subscriptionStartDate;
    private Date subscriptionEndDate;
    private String vendorDescription;
    private String vendorStatus;

    private Integer subscriptionId;
    private String subscriptionName;

    private Integer categoryId;
    private String categoryName;

    private List<VendorImagesResDto> vendorImagesList;


    private String message;
}
