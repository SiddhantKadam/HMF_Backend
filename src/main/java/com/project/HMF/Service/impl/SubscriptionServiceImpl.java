package com.project.HMF.Service.impl;

import com.project.HMF.Controller.SubscriptionController;
import com.project.HMF.Dao.SubscriptionDao;
import com.project.HMF.Model.BannerMaster;
import com.project.HMF.Model.SubscriptionMaster;
import com.project.HMF.Service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionDao subscriptionDao;

    @Override
    public boolean subscriptionCreate(SubscriptionMaster subscriptionMaster) {
        try {
            subscriptionDao.save(subscriptionMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean subscriptionUpdate(SubscriptionMaster subscriptionMaster) {
        try {
            subscriptionDao.save(subscriptionMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAllSubscription() {
        return (List) subscriptionDao.findAll();
    }

    @Override
    public SubscriptionMaster getSubscriptionById(Integer subscriptionId) {
        SubscriptionMaster subscriptionMaster = new SubscriptionMaster();
        try {
            subscriptionMaster = subscriptionDao.findOne(subscriptionId);
            return subscriptionMaster;
        } catch (Exception e) {
            e.printStackTrace();
            return subscriptionMaster;
        }
    }

    @Override
    public List activeSubscription() {
        List list = subscriptionDao.findAllByStatus("Active");
        return list;
    }
}
