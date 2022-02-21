package com.project.HMF.Dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class VendorValidateOtpReqDto {
    private Integer otp;
    private Integer vendorId;

}
