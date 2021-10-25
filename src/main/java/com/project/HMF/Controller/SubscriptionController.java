package com.project.HMF.Controller;

import com.project.HMF.Model.BannerMaster;
import com.project.HMF.Model.SubscriptionMaster;
import com.project.HMF.Service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    private ResponseEntity create(@RequestBody SubscriptionMaster subscriptionMaster) {
        boolean flag = subscriptionService.subscriptionCreate(subscriptionMaster);
        if (flag) {
            return new ResponseEntity(flag, HttpStatus.OK);
        } else {
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    private ResponseEntity update(@RequestBody SubscriptionMaster subscriptionMaster) {
        boolean flag = subscriptionService.subscriptionUpdate(subscriptionMaster);
        if (flag) {
            return new ResponseEntity(flag, HttpStatus.OK);
        } else {
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    private ResponseEntity getAllSubscriptions() {
        List list = subscriptionService.getAllSubscription();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/getById/{subscriptionId}")
    private ResponseEntity getSubscriptionById(@PathVariable Integer subscriptionId) {
        SubscriptionMaster subscriptionMaster = subscriptionService.getSubscriptionById(subscriptionId);
        if (subscriptionMaster != null) {
            return new ResponseEntity(subscriptionMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity(subscriptionMaster, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/activeSubscription")
    private ResponseEntity activeSubscription() {
        List list = subscriptionService.activeSubscription();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
