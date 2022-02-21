package com.project.HMF.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "job_master")
@Setter
@Getter
@NoArgsConstructor
public class JobMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Integer jobId;

    @Column(length = 500)
    private String jobName;

    @Column(length = 15)
    private String jobDescription;

    @Column(length = 15)
    private String noOfPositions;

    @Column(length = 15)
    private String jobStatus;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vendor_id")
    @JsonIgnore
    private VendorMaster vendorMaster;

    @Transient
    private Integer vendorId;

    @Transient
    private String vendorBusinessName;

    @Transient
    private String vendorBusinessAddress;

    @Transient
    private String vendorMobileNo;
}
