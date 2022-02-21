package com.project.HMF.Controller;

import com.project.HMF.Dto.req.*;
import com.project.HMF.Dto.res.*;
import com.project.HMF.Model.UserMaster;
import com.project.HMF.Model.VendorMaster;
import com.project.HMF.Service.UserService;
import com.project.HMF.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
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

    @GetMapping(value = "/getActiveVendor")
    private ResponseEntity getActiveVendor() {
        List list = vendorService.getActiveVendor();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/getById/{vendorId}")
    private ResponseEntity getVendorById(@PathVariable Integer vendorId) {
        VendorMaster vendorMaster = vendorService.getVendorById(vendorId);
        if (vendorMaster != null) {
            return new ResponseEntity(vendorMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity(vendorMaster, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/updateSubscription/vendorSubscription")
    private ResponseEntity updateSubscription(@RequestBody VendorSubscriptionReqDto vendorSubscriptionReqDto){
        Boolean flag = vendorService.updateSubscription(vendorSubscriptionReqDto);
        return new ResponseEntity(flag, HttpStatus.CREATED);
    }

    @GetMapping(value = "/changePassword/{vendorId}/{password}")
    private ResponseEntity vendorChangePassword(@PathVariable Integer vendorId, @PathVariable String password) {
        Boolean flag = vendorService.updatePassword(vendorId, password);
        return new ResponseEntity(flag, HttpStatus.CREATED);
    }

    @GetMapping(value = "/vendorForgotPassword/{vendorMobileNo}")
    public ResponseEntity vendorForgotPassword(@PathVariable String vendorMobileNo)
    {
        VendorForgotResDto vendorForgotResDto = vendorService.vendorForgotPassword(vendorMobileNo);
        if (vendorForgotResDto != null) {
            return new ResponseEntity(vendorForgotResDto, HttpStatus.OK);
        } else {
            return new ResponseEntity(vendorForgotResDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/validateVendorOtp")
    public ResponseEntity validateOtp(@RequestBody VendorValidateOtpReqDto vendorValidateOtpReqDto)
    {
        boolean flag = vendorService.validateOtp(vendorValidateOtpReqDto);
        return new ResponseEntity(flag,HttpStatus.OK);
    }

    @GetMapping(value = "/getVendorByCategoryId/{categoryId}")
    private ResponseEntity getByCategoryId(@PathVariable Integer categoryId) {
        List list = vendorService.getByCategoryId(categoryId);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/searchVendor/{searchText}/{categoryId}")
    private ResponseEntity searchVendor(@PathVariable String searchText,@PathVariable Integer categoryId)
    {
        List list = vendorService.searchVendor(searchText,categoryId);
        if(list.size()!=0)
        {
            return new ResponseEntity(list,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(list,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Scheduled(cron = "0 0 1 1/1 * ?")
    private ResponseEntity inActiveVendor(){

        Boolean flag = vendorService.inActiveVendor();

        if(flag){return new ResponseEntity(flag, HttpStatus.CREATED);}
        else{return new ResponseEntity(flag,HttpStatus.INTERNAL_SERVER_ERROR);}
    }

    @PostMapping(value = "/getReportFromToDate")
    private ResponseEntity getReportListFromToDate(@RequestBody ReportReqDto reportReqDto)
    {
        List list= vendorService.getVendorReporFromToDate(reportReqDto);

        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/deleteVendorImage/{vendorImageId}")
    private ResponseEntity deleteVendorImage(@PathVariable Integer vendorImageId)
    {
        Boolean flag = vendorService.deleteVendorImage(vendorImageId);

        if(flag){return new ResponseEntity(flag, HttpStatus.CREATED);}
        else{return new ResponseEntity(flag,HttpStatus.INTERNAL_SERVER_ERROR);}
    }

    @GetMapping(value = "/getVendorImage/{vendorId}")
    private ResponseEntity getVendorImage(@PathVariable Integer vendorId)
    {
        List list = vendorService.getVendorImage(vendorId);

        return new ResponseEntity(list, HttpStatus.OK);
    }

}
