package com.project.HMF.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "banner_master")
@Setter
@Getter
@NoArgsConstructor
public class BannerMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Integer bannerId;

    @Column(length = 500)
    private String bannerImage;

    @Column(length = 20)
    private String imageDescription;

    @Column(length = 20)
    private Date startdDate;

    @Column(length = 20)
    private Date endDate;

    @Column(length = 20)
    private String status;
}
