package com.project.HMF.Dao;

import com.project.HMF.Model.UserMaster;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserDao extends CrudRepository<UserMaster,Integer> {
    UserMaster findOneByUserMobileNo(String userMobileNo);

    UserMaster findAllByUserMobileNo(String mobileNo);

    @Transactional
    @Modifying
    @Query("update UserMaster as um set um.userPassword=:password where um.userId=:userId")
    Integer updatePassword(@Param("userId") Integer userId, @Param("password") String password);
}
