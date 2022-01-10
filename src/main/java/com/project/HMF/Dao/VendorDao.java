package com.project.HMF.Dao;

import com.project.HMF.Dto.res.BusinessResDto;
import com.project.HMF.Model.CategoryMaster;
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
    @Query("update from VendorMaster as vm set vm.subscriptionMaster.subscriptionId=:subscriptionId,vm.subscriptionStartDate=:date,vm.subscriptionEndDate=:afterMonthAddDate where vm.vendorId=:vendorId")
    Integer updateSubscription(@Param("vendorId") Integer vendorId, @Param("subscriptionId") Integer subscriptionId, @Param("date") Date date,@Param("afterMonthAddDate") Date afterMonthAddDate);


    @Transactional
    @Modifying
    @Query("update VendorMaster as vm set vm.vendorPassword=:password where vm.vendorId=:vendorId")
    Integer updatePassword(@Param("vendorId") Integer vendorId, @Param("password") String password);

    List<VendorMaster> findAllByCategoryMaster(CategoryMaster categoryMaster);

//    ==== Get Vendor by categoryId ====
    @Query("select vm from VendorMaster as vm where vm.categoryMaster.categoryId=:categoryId and vm.vendorStatus='Active'")
    List<VendorMaster> getAllVendor(@Param("categoryId")Integer categoryId);

//    ==== Search ====
    @Query("select vm from VendorMaster as vm where vm.categoryMaster.categoryId=:categoryId and vm.vendorStatus='Active' and vm.vendorFName like %:searchText% or vm.vendorLName like %:searchText% or vm.vendorMobileNo like %:searchText% or vm.vendorBusinessName like %:searchText% or vm.vendorBusinessAddress like %:searchText% or vm.categoryMaster.categoryName like %:searchText% or vm.subscriptionMaster.subscriptionName like %:searchText%")
    List<VendorMaster> getAllSearchedVendor(@Param("searchText") String searchText,@Param("categoryId") Integer categoryId);

    @Transactional
    @Modifying
    @Query("update VendorMaster as vm set vm.vendorStatus='Inactive' where vm.vendorId=:vendorId")
    Integer getDeletedVendor(@Param("vendorId")Integer vendorId);
}
