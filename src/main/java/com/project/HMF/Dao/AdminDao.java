package com.project.HMF.Dao;

import com.project.HMF.Model.AdminSetting;
import com.project.HMF.Model.UserMaster;
import org.springframework.data.repository.CrudRepository;

public interface AdminDao extends CrudRepository<AdminSetting,Integer> {

    AdminSetting findAllByAdminMobileNo(String adminMobileNo);
}
