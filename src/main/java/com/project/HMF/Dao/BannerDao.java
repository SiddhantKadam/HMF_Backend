package com.project.HMF.Dao;

import com.project.HMF.Model.BannerMaster;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BannerDao extends CrudRepository<BannerMaster,Integer> {

    List findAllByStatus(String active);
}
