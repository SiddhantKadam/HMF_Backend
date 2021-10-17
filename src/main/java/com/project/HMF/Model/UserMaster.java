package com.project.HMF.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_master")
@Setter
@Getter
@NoArgsConstructor
public class UserMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Integer userId;

    @Column(length = 20)
    private String userFName;

    @Column(length = 20)
    private String userLName;

    @Column(length = 20)
    private String userMobileNo;

    @Column(length = 20)
    private String userPassword;

    @Column(length = 20)
    private String userStatus;
}
