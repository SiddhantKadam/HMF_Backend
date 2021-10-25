package com.project.HMF.Dto.res;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BusinessResDto {

    private Integer vendorId;
    private String vendorBusinessName;
    private String vendorBusinessImage;
    private String vendorBusinessAddress;

    public BusinessResDto(Integer vendorId, String vendorBusinessName, String vendorBusinessImage, String vendorBusinessAddress) {
        this.vendorId = vendorId;
        this.vendorBusinessName = vendorBusinessName;
        this.vendorBusinessImage = vendorBusinessImage;
        this.vendorBusinessAddress = vendorBusinessAddress;
    }
}
