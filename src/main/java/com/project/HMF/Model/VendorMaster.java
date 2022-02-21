package com.project.HMF.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.HMF.Dto.res.VendorImagesResDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vendor_master")
@Setter
@Getter
@NoArgsConstructor
public class VendorMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Integer vendorId;

    @Column(length = 20)
    private String vendorFName;

    @Column(length = 20)
    private String vendorLName;

    @Column(length = 20)
    private String vendorMobileNo;

    @Column(length = 20)
    private String vendorBusinessMobileNo;

    @Column(length = 20)
    private String vendorReferenceMobileNo;

    @Column(length = 20)
    private String vendorPassword;

    @Column(length = 50)
    private String vendorBusinessName;

    @Column(length = 500)
    private String vendorBusinessImage;

    @Column(length = 100)
    private String vendorBusinessAddress;

    @Column(length = 500)
    private String vendorBusinessProof;

    @Column(length = 100)
    private String vendorOpeningTime;

    @Column(length = 100)
    private String vendorClosingTime;

    @Column(length = 100)
    private String vendorHoliday;

    @Column(length = 100)
    private Date vendorRegistrationDate;

    @Column(length = 20)
    private String registrationType;

    @Column(length = 500)
    private String vendorDescription;

    @Column(length = 7)
    private Integer otp;

    @Column(length = 20)
    private String vendorStatus;

    @Transient
    private List<VendorImages> vendorImagesList;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoryId")
    @JsonIgnore
    private CategoryMaster categoryMaster;

    @Transient
    private Integer categoryId;

    @Transient
    private String categoryName;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="subscriptionId")
    @JsonIgnore
    private SubscriptionMaster subscriptionMaster;

    @Transient
    private Integer subscriptionId;

    @Transient
    private String subscriptionName;

    @Column(length = 20)
    private Date subscriptionStartDate;

    @Column(length = 20)
    private Date subscriptionEndDate;

}
