package com.project.HMF.Dao;

import com.project.HMF.Model.BannerMaster;
import com.project.HMF.Model.CategoryMaster;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryDao extends CrudRepository<CategoryMaster,Integer> {

    List findAllByStatus(String active);
}
