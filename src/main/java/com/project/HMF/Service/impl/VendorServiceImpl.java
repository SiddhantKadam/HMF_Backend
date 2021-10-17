package com.project.HMF.Service.impl;

import com.project.HMF.Dao.VendorDao;
import com.project.HMF.Dto.req.VendorLoginReqDto;
import com.project.HMF.Dto.req.VendorSubscriptionReqDto;
import com.project.HMF.Dto.res.VendorLoginResDto;
import com.project.HMF.Dto.res.VendorRegistrationResDto;
import com.project.HMF.Model.CategoryMaster;
import com.project.HMF.Model.VendorMaster;
import com.project.HMF.Service.VendorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorDao vendorDao;

    @Override
    public VendorRegistrationResDto create(VendorMaster vendorMaster) {

        VendorRegistrationResDto vendorRegistrationResDto = new VendorRegistrationResDto();
        VendorMaster vendorMaster1 = vendorDao.findOneByVendorMobileNo(vendorMaster.getVendorMobileNo());
        if (vendorMaster1 == null) {
            try {
                CategoryMaster categoryMaster = new CategoryMaster();
                categoryMaster.setCategoryId(vendorMaster.getCategoryId());
                vendorMaster.setCategoryMaster(categoryMaster);
                vendorMaster.setVendorStatus("Active");
                vendorDao.save(vendorMaster);
                vendorRegistrationResDto.setMessage("Save Succesfully");
            } catch (Exception e) {
                e.printStackTrace();
                vendorRegistrationResDto.setMessage("Failed");
            }
        } else {
            vendorRegistrationResDto.setMessage("Mobile No Already Exist");
        }
        return vendorRegistrationResDto;
    }

    @Override
    public VendorLoginResDto vendorLogin(VendorLoginReqDto vendorLoginReqDto) {

        VendorMaster vendorMaster = vendorDao.findAllByVendorMobileNo(vendorLoginReqDto.getVendorMobileNo());
        VendorLoginResDto vendorLoginResDto = new VendorLoginResDto();
        if (vendorMaster != null) {
            if (vendorMaster.getVendorPassword().equals(vendorLoginReqDto.getVendorPassword())) {
                if (vendorMaster.getVendorStatus().equals("Active")) {

                    vendorLoginResDto.setResponseCode(HttpStatus.OK.value());
                    vendorLoginResDto.setMessage("Login Success");
                    BeanUtils.copyProperties(vendorMaster, vendorLoginResDto);

                } else {
                    vendorLoginResDto.setResponseCode(HttpStatus.FORBIDDEN.value());
                    vendorLoginResDto.setMessage("Account Has Been Blocked");
                }
            } else {
                vendorLoginResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
                vendorLoginResDto.setMessage("Password Is Invalid");
            }
        }
        if (vendorMaster == null) {
            vendorLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            vendorLoginResDto.setMessage("Mobile Number is Not Found");
        } else if (!vendorMaster.getVendorMobileNo().equals(vendorLoginReqDto.getVendorMobileNo())) {
            System.out.println("Mobile No is not equal");
            vendorLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            vendorLoginResDto.setMessage("Mobile Number is Not Found");
        }
        return vendorLoginResDto;
    }

    @Override
    public List getAllVendor() {
        List<VendorMaster> list= (List) vendorDao.findAll();
        for (VendorMaster vendorMaster:list)
        {
            if (vendorMaster.getCategoryMaster()!=null)
            {
                vendorMaster.setCategoryId(vendorMaster.getCategoryMaster().getCategoryId());
                vendorMaster.setCategoryName(vendorMaster.getCategoryMaster().getCategoryName());
            }
        }
        return list;
    }

    @Override
    public VendorMaster getVendorById(Integer vendorId) {
        VendorMaster vendorMaster = new VendorMaster();
        try {
            vendorMaster = vendorDao.findOne(vendorId);
            if (vendorMaster.getCategoryMaster()!=null)
            {
                vendorMaster.setCategoryId(vendorMaster.getCategoryMaster().getCategoryId());
                vendorMaster.setCategoryName(vendorMaster.getCategoryMaster().getCategoryName());
            }
            return vendorMaster;
        } catch (Exception e) {
            e.printStackTrace();
            return vendorMaster;
        }
    }

    @Override
    public VendorRegistrationResDto update(VendorMaster vendorMaster) {
        VendorRegistrationResDto vendorRegistrationResDto = new VendorRegistrationResDto();
            try {
                CategoryMaster categoryMaster = new CategoryMaster();
                categoryMaster.setCategoryId(vendorMaster.getCategoryId());
                vendorMaster.setCategoryMaster(categoryMaster);
                vendorDao.save(vendorMaster);
                vendorRegistrationResDto.setMessage("Update Succesfully");
            } catch (Exception e) {
                e.printStackTrace();
                vendorRegistrationResDto.setMessage("Failed");
            }
        return vendorRegistrationResDto;
    }

    @Override
    public Boolean updateSubscription(VendorSubscriptionReqDto vendorSubscriptionReqDto) {
        Integer updateSubscription=vendorDao.updateSubscription(vendorSubscriptionReqDto.getVendorId(),vendorSubscriptionReqDto.getSubscriptionId(),new Date());
        return updateSubscription!=0;
    }
}
