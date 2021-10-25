package com.project.HMF.Dao;

import com.project.HMF.Dto.res.BusinessResDto;
import com.project.HMF.Model.VendorMaster;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface VendorDao extends CrudRepository<VendorMaster,Integer> {

    VendorMaster findOneByVendorMobileNo(String vendorMobileNo);

    VendorMaster findAllByVendorMobileNo(String vendorMobileNo);

    @Transactional
    @Modifying
    @Query("update from VendorMaster as vm set vm.subscriptionMaster.subscriptionId=:subscriptionId,vm.subscriptionStartDate=:date where vm.vendorId=:vendorId")
    Integer updateSubscription(@Param("vendorId") Integer vendorId,@Param("subscriptionId") Integer subscriptionId,@Param("date") Date date);


    @Transactional
    @Modifying
    @Query("update VendorMaster as vm set vm.vendorPassword=:password where vm.vendorId=:vendorId")
    Integer updatePassword(@Param("vendorId") Integer vendorId, @Param("password") String password);

//    @Query("select new com.project.HMF.dto.res.BusinessResDto( vm.vendorId  , vm.vendorBusinessName, vm.vendorBusinessImage, vm.vendorBusinessAddress ) from VendorMaster as vm")
//    List<BusinessResDto> getDateWiseBusinessList();
}
