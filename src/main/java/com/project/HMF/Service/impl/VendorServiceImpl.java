package com.project.HMF.Service.impl;

import com.project.HMF.Dao.SubscriptionDao;
import com.project.HMF.Dao.UserDao;
import com.project.HMF.Dao.VendorDao;
import com.project.HMF.Dto.req.VendorLoginReqDto;
import com.project.HMF.Dto.req.VendorSubscriptionReqDto;
import com.project.HMF.Dto.res.BusinessResDto;
import com.project.HMF.Dto.res.VendorLoginResDto;
import com.project.HMF.Dto.res.VendorRegistrationResDto;
import com.project.HMF.Model.CategoryMaster;
import com.project.HMF.Model.SubscriptionMaster;
import com.project.HMF.Model.UserMaster;
import com.project.HMF.Model.VendorMaster;
import com.project.HMF.Service.VendorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorDao vendorDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private SubscriptionDao subscriptionDao;

    @Override
    public VendorRegistrationResDto create(VendorMaster vendorMaster) {

        VendorRegistrationResDto vendorRegistrationResDto = new VendorRegistrationResDto();
        UserMaster userMaster1 = userDao.findOneByUserMobileNo(vendorMaster.getVendorMobileNo());
        VendorMaster vendorMaster1 = vendorDao.findOneByVendorMobileNo(vendorMaster.getVendorMobileNo());
        if (vendorMaster1 == null && userMaster1 == null) {
            try {
                CategoryMaster categoryMaster = new CategoryMaster();
                categoryMaster.setCategoryId(vendorMaster.getCategoryId());
                vendorMaster.setCategoryMaster(categoryMaster);

                vendorMaster.setVendorStatus("Active");
                vendorDao.save(vendorMaster);
                vendorRegistrationResDto.setMessage("Save Succesfully");
                vendorRegistrationResDto.setVendorId(vendorMaster.getVendorId());
                vendorRegistrationResDto.setVendorFName(vendorMaster.getVendorFName());
                vendorRegistrationResDto.setVendorLName(vendorMaster.getVendorLName());
                vendorRegistrationResDto.setVendorMobileNo(vendorMaster.getVendorMobileNo());
                vendorRegistrationResDto.setRegistrationType(vendorMaster.getRegistrationType());
                vendorRegistrationResDto.setVendorStatus(vendorMaster.getVendorStatus());

                vendorRegistrationResDto.setVendorBusinessName(vendorMaster.getVendorBusinessName());
                vendorRegistrationResDto.setVendorBusinessAddress(vendorMaster.getVendorBusinessAddress());
                vendorRegistrationResDto.setVendorBusinessProof(vendorMaster.getVendorBusinessProof());
                vendorRegistrationResDto.setVendorBusinessImage(vendorMaster.getVendorBusinessImage());

                if (vendorMaster.getCategoryMaster() != null) {
                    vendorRegistrationResDto.setCategoryId(vendorMaster.getCategoryMaster().getCategoryId());
                    vendorRegistrationResDto.setCategoryName(vendorMaster.getCategoryMaster().getCategoryName());
                }

                if (vendorMaster.getSubscriptionMaster() != null) {
                    vendorRegistrationResDto.setSubscriptionId(vendorMaster.getSubscriptionMaster().getSubscriptionId());
                    vendorRegistrationResDto.setSubscriptionName(vendorMaster.getSubscriptionMaster().getSubscriptionName());
                }

                vendorRegistrationResDto.setSubscriptionStartDate(vendorMaster.getSubscriptionStartDate());
                vendorRegistrationResDto.setSubscriptionEndDate(vendorMaster.getSubscriptionEndDate());
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
                if (vendorMaster.getVendorStatus().equals("Active") && vendorMaster.getSubscriptionEndDate().after(new Date())) {

                    vendorLoginResDto.setResponseCode(HttpStatus.OK.value());
                    vendorLoginResDto.setMessage("Login Success");
                    BeanUtils.copyProperties(vendorMaster, vendorLoginResDto);
                    if (vendorMaster.getSubscriptionMaster() != null) {
                        vendorLoginResDto.setSubscriptionId(vendorMaster.getSubscriptionMaster().getSubscriptionId());
                        vendorLoginResDto.setSubscriptionName(vendorMaster.getSubscriptionMaster().getSubscriptionName());
                    }
                    if (vendorMaster.getCategoryMaster() != null) {
                        vendorLoginResDto.setCategoryId(vendorMaster.getCategoryMaster().getCategoryId());
                        vendorLoginResDto.setCategoryName(vendorMaster.getCategoryMaster().getCategoryName());
                    }

                } else if (vendorMaster.getVendorStatus().equals("Active") && vendorMaster.getSubscriptionEndDate().before(new Date())) {
                    vendorLoginResDto.setResponseCode(HttpStatus.FORBIDDEN.value());
                    vendorLoginResDto.setMessage("Subscription plan is expired");
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
        List<VendorMaster> list = (List) vendorDao.findAll();
        for (VendorMaster vendorMaster : list) {
            if (vendorMaster.getCategoryMaster() != null) {
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
            if (vendorMaster.getCategoryMaster() != null) {
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
        Boolean flag = false;
        SubscriptionMaster subscriptionMaster = subscriptionDao.findOne(vendorSubscriptionReqDto.getSubscriptionId());
        if (subscriptionMaster != null) {
            Calendar cal = Calendar.getInstance();
            Date today = cal.getTime();//09-11-2021
            cal.add(Calendar.YEAR, Integer.parseInt(subscriptionMaster.getValidityInYears()));
            Date afterYearAddDate = cal.getTime();//09-11-2022
            System.out.println("afterYearAddDate--- " + afterYearAddDate);

            cal.add(Calendar.MONTH, Integer.parseInt(subscriptionMaster.getValidityInMonths()));
            Date afterMonthAddDate = cal.getTime();
            System.out.println("afterMonthAddDate--- " + afterMonthAddDate);

            Integer updateSubscription = vendorDao.updateSubscription(vendorSubscriptionReqDto.getVendorId(), vendorSubscriptionReqDto.getSubscriptionId(), new Date(), afterMonthAddDate);
            if (updateSubscription != 0) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public Boolean updatePassword(Integer vendorId, String password) {
        Integer flag = vendorDao.updatePassword(vendorId, password);
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean vendorForgotPassword(String vendorMobileNo) {
        VendorMaster vendorMaster1 = vendorDao.findOneByVendorMobileNo(vendorMobileNo);
        if (vendorMaster1 == null) {
            System.out.println("OTP False");
            return false;
        } else {
            System.out.println("OTP True");
            return true;
        }
    }

    @Override
    public List<VendorMaster> getByCategoryId(Integer categoryId) {
        List<VendorMaster> list = vendorDao.getAllVendor(categoryId);
        for (VendorMaster vendorMaster : list) {
            if (vendorMaster.getCategoryMaster() != null) {
                vendorMaster.setCategoryId(vendorMaster.getCategoryMaster().getCategoryId());
                vendorMaster.setCategoryName(vendorMaster.getCategoryMaster().getCategoryName());
            }
            if (vendorMaster.getSubscriptionMaster() != null) {
                vendorMaster.setSubscriptionId(vendorMaster.getSubscriptionMaster().getSubscriptionId());
                vendorMaster.setSubscriptionName(vendorMaster.getSubscriptionMaster().getSubscriptionName());
            }
        }
        return list;
    }

    @Override
    public List searchVendor(String searchText, Integer categoryId) {
        List<VendorMaster> list = vendorDao.getAllSearchedVendor(searchText, categoryId);
        for (VendorMaster vendorMaster : list) {
            if (vendorMaster.getCategoryMaster() != null) {
                vendorMaster.setCategoryId(vendorMaster.getCategoryMaster().getCategoryId());
                vendorMaster.setCategoryName(vendorMaster.getCategoryMaster().getCategoryName());
            }
            if (vendorMaster.getSubscriptionMaster() != null) {
                vendorMaster.setSubscriptionId(vendorMaster.getSubscriptionMaster().getSubscriptionId());
                vendorMaster.setSubscriptionName(vendorMaster.getSubscriptionMaster().getSubscriptionName());
            }
        }
        return list;
    }

    @Override
    public Boolean inActiveVendor() {
        Boolean flag = true;
        Date todayDate = new Date();
        List<VendorMaster> list = (List) vendorDao.findAll();
        for (VendorMaster vendorMaster : list) {
            if (vendorMaster.getSubscriptionEndDate().before(new Date())) {
                Integer deletedVendor = vendorDao.getDeletedVendor(vendorMaster.getVendorId());
            }
        }
        return flag;
    }
}
