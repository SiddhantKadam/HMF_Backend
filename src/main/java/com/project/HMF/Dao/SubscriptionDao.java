package com.project.HMF.Dao;

import com.project.HMF.Controller.SubscriptionController;
import com.project.HMF.Model.SubscriptionMaster;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionDao extends CrudRepository<SubscriptionMaster,Integer> {

    List findAllByStatus(String active);
}
