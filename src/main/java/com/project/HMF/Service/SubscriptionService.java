package com.project.HMF.Service;

import com.project.HMF.Controller.SubscriptionController;
import com.project.HMF.Model.SubscriptionMaster;

import java.util.List;

public interface SubscriptionService {

    boolean subscriptionCreate(SubscriptionMaster subscriptionMaster);

    boolean subscriptionUpdate(SubscriptionMaster subscriptionMaster);

    List getAllSubscription();

    SubscriptionMaster getSubscriptionById(Integer subscriptionId);

    List activeSubscription();
}
