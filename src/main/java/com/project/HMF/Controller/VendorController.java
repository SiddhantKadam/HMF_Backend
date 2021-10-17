package com.project.HMF.Controller;

import com.project.HMF.Dto.req.UserLoginReqDto;
import com.project.HMF.Dto.req.VendorLoginReqDto;
import com.project.HMF.Dto.req.VendorSubscriptionReqDto;
import com.project.HMF.Dto.res.UserLoginResDto;
import com.project.HMF.Dto.res.UserRegistrationResDto;
import com.project.HMF.Dto.res.VendorLoginResDto;
import com.project.HMF.Dto.res.VendorRegistrationResDto;
import com.project.HMF.Model.UserMaster;
import com.project.HMF.Model.VendorMaster;
import com.project.HMF.Service.UserService;
import com.project.HMF.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping
    private ResponseEntity create(@RequestBody VendorMaster vendorMaster){
        VendorRegistrationResDto vendorRegistrationResDto = vendorService.create(vendorMaster);
        return new ResponseEntity(vendorRegistrationResDto, HttpStatus.CREATED);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody VendorMaster vendorMaster){
        VendorRegistrationResDto vendorRegistrationResDto = vendorService.update(vendorMaster);
        return new ResponseEntity(vendorRegistrationResDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/vendorLogin")
    public ResponseEntity vendorLogin(@RequestBody VendorLoginReqDto vendorLoginReqDto)
    {
        VendorLoginResDto vendorLoginResDto = vendorService.vendorLogin(vendorLoginReqDto);
        return new ResponseEntity(vendorLoginResDto, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity getAllVendor() {
        List list = vendorService.getAllVendor();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{vendorId}")
    private ResponseEntity getVendorById(@PathVariable Integer vendorId) {
        VendorMaster vendorMaster = vendorService.getVendorById(vendorId);
        if (vendorMaster != null) {
            return new ResponseEntity(vendorMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity(vendorMaster, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{vendorSubscription}")
    private ResponseEntity updateSubscription(@RequestBody VendorSubscriptionReqDto vendorSubscriptionReqDto){
        Boolean flag = vendorService.updateSubscription(vendorSubscriptionReqDto);
        return new ResponseEntity(flag, HttpStatus.CREATED);
    }

}
