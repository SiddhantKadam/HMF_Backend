package com.project.HMF.Dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VendorLoginReqDto {

    private String vendorMobileNo;
    private String vendorPassword;

}
