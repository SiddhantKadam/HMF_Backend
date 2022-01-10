package com.project.HMF.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "admin_setting")
@Setter
@Getter
@NoArgsConstructor
public class AdminSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Integer adminId;

    @Column(length = 20)
    private String adminMobileNo;

    @Column(length = 20)
    private String adminPassword;

    @Column(length = 20)
    private String adminStatus;
}
