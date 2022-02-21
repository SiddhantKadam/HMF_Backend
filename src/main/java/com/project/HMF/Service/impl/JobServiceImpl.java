package com.project.HMF.Service.impl;

import com.project.HMF.Dao.CategoryDao;
import com.project.HMF.Dao.JobDao;
import com.project.HMF.Model.CategoryMaster;
import com.project.HMF.Model.JobMaster;
import com.project.HMF.Model.VendorMaster;
import com.project.HMF.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;

    @Override
    public boolean jobCreate(JobMaster jobMaster) {
        try {
            VendorMaster vendorMaster = new VendorMaster();
            vendorMaster.setVendorId(jobMaster.getVendorId());
            jobMaster.setVendorMaster(vendorMaster);
            jobDao.save(jobMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean jobUpdate(JobMaster jobMaster) {
        try {
            VendorMaster vendorMaster = new VendorMaster();
            vendorMaster.setVendorId(jobMaster.getVendorId());
            jobMaster.setVendorMaster(vendorMaster);
            jobDao.save(jobMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAllJob() {
        List<JobMaster> list = (List) jobDao.findAll();
        for (JobMaster jobMaster : list) {
            if (jobMaster.getVendorMaster() != null) {
                jobMaster.setVendorId(jobMaster.getVendorMaster().getVendorId());
                jobMaster.setVendorBusinessName(jobMaster.getVendorMaster().getVendorBusinessName());
                jobMaster.setVendorBusinessAddress(jobMaster.getVendorMaster().getVendorBusinessAddress());
                jobMaster.setVendorMobileNo(jobMaster.getVendorMaster().getVendorMobileNo());
            }
        }
        return list;
    }

    @Override
    public JobMaster getJobById(Integer jobId) {
        JobMaster jobMaster = new JobMaster();
        try {
            jobMaster = jobDao.findOne(jobId);
            jobMaster.setVendorId(jobMaster.getVendorMaster().getVendorId());
            jobMaster.setVendorBusinessName(jobMaster.getVendorMaster().getVendorBusinessName());
            jobMaster.setVendorBusinessAddress(jobMaster.getVendorMaster().getVendorBusinessAddress());
            jobMaster.setVendorMobileNo(jobMaster.getVendorMaster().getVendorMobileNo());
            return jobMaster;
        } catch (Exception e) {
            e.printStackTrace();
            return jobMaster;
        }
    }

    @Override
    public List activeJob() {
        List<JobMaster> list = jobDao.findAllByJobStatus("Active");
        for (JobMaster jobMaster : list) {
            if (jobMaster.getVendorMaster() != null) {
                jobMaster.setVendorId(jobMaster.getVendorMaster().getVendorId());
                jobMaster.setVendorBusinessName(jobMaster.getVendorMaster().getVendorBusinessName());
                jobMaster.setVendorBusinessAddress(jobMaster.getVendorMaster().getVendorBusinessAddress());
                jobMaster.setVendorMobileNo(jobMaster.getVendorMaster().getVendorMobileNo());
            }
        }
        return list;
    }
}
