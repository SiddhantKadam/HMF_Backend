package com.project.HMF.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "vendor_images")
@Setter
@Getter
@NoArgsConstructor
public class VendorImages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Integer vendorImageId;

    @Column(length = 500)
    private String vendorImagePath;

    @Column(length = 15)
    private String vendorImageStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendorId_id")
    private VendorMaster vendorMaster;
}
