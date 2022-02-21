package com.project.HMF.Dao;

import com.project.HMF.Model.CategoryMaster;
import com.project.HMF.Model.JobMaster;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobDao extends CrudRepository<JobMaster,Integer> {
    List findAllByJobStatus(String active);
}
