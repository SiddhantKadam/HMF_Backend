package com.project.HMF.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscription_master")
@Setter
@Getter
@NoArgsConstructor
public class SubscriptionMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Integer subscriptionId;

    @Column(length = 20)
    private String subscriptionName;

    @Column(length = 20)
    private String validityInYears;

    @Column(length = 20)
    private String validityInMonths;

    @Column(length = 20)
    private String subscriptionDescription;

    @Column(length = 20)
    private Double subscriptionAmount;

    @Column(length = 20)
    private String status;
}
