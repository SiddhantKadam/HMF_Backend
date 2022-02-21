package com.project.HMF.Dao;

import com.project.HMF.Dto.res.ReportResDto;
import com.project.HMF.Model.UserMaster;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface UserDao extends CrudRepository<UserMaster,Integer> {
    UserMaster findOneByUserMobileNo(String userMobileNo);

    UserMaster findAllByUserMobileNo(String mobileNo);

    @Transactional
    @Modifying
    @Query("update UserMaster as um set um.userPassword=:password where um.userId=:userId")
    Integer updatePassword(@Param("userId") Integer userId, @Param("password") String password);

    @Query("select new com.project.HMF.Dto.res.ReportResDto(um.userId,um.userFName,um.userLName,um.userMobileNo,um.registrationDate,um.userStatus) from UserMaster as um where um.registrationDate between date(:fromDate) and date(:toDate)")
    List<ReportResDto> getUserReportList(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

    List findAllByUserStatus(String active);

    //    ==== OTP ====
    @Transactional
    @Modifying
    @Query("update UserMaster as um set um.otp=:otp where um.userId=:userId")
    Integer updateOtp(@Param("userId") Integer userId,@Param("otp") Integer otp);
}
