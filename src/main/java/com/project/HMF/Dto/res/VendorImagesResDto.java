package com.project.HMF.Dto.res;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class VendorImagesResDto {
    private Integer vendorImageId;
    private String vendorImagePath;
    private String vendorImageStatus;

    public VendorImagesResDto(Integer vendorImageId, String vendorImagePath, String vendorImageStatus) {
        this.vendorImageId = vendorImageId;
        this.vendorImagePath = vendorImagePath;
        this.vendorImageStatus = vendorImageStatus;
    }

}
