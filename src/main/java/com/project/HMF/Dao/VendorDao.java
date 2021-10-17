package com.project.HMF.Dao;

import com.project.HMF.Model.VendorMaster;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface VendorDao extends CrudRepository<VendorMaster,Integer> {

    VendorMaster findOneByVendorMobileNo(String vendorMobileNo);

    VendorMaster findAllByVendorMobileNo(String vendorMobileNo);

    @Transactional
    @Modifying
    @Query("update from VendorMaster as vm set vm.subscriptionMaster.subscriptionId=:subscriptionId,vm.subscriptionStartDate=:date where vm.vendorId=:vendorId")
    Integer updateSubscription(@Param("vendorId") Integer vendorId,@Param("subscriptionId") Integer subscriptionId,@Param("date") Date date);
}
