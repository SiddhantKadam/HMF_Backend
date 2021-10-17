package com.project.HMF.Service;

import com.project.HMF.Dto.req.VendorLoginReqDto;
import com.project.HMF.Dto.req.VendorSubscriptionReqDto;
import com.project.HMF.Dto.res.VendorLoginResDto;
import com.project.HMF.Dto.res.VendorRegistrationResDto;
import com.project.HMF.Model.VendorMaster;

import java.util.List;

public interface VendorService {
    VendorRegistrationResDto create(VendorMaster vendorMaster);

    VendorLoginResDto vendorLogin(VendorLoginReqDto vendorLoginReqDto);

    List getAllVendor();

    VendorMaster getVendorById(Integer vendorId);

    VendorRegistrationResDto update(VendorMaster vendorMaster);

    Boolean updateSubscription(VendorSubscriptionReqDto vendorSubscriptionReqDto);
}
