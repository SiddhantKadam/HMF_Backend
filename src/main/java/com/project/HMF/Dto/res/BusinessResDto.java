package com.project.HMF.Dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BusinessResDto {

    private Integer vendorId;
    private String vendorBusinessName;
    private String vendorBusinessImage;
    private String vendorBusinessAddress;
}
