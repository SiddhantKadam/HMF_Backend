package com.project.HMF.Service.impl;

import com.project.HMF.Dao.BannerDao;
import com.project.HMF.Model.BannerMaster;
import com.project.HMF.Service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    public boolean bannerCreate(BannerMaster bannerMaster) {
        try {
            bannerDao.save(bannerMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean bannerUpdate(BannerMaster bannerMaster) {
        try {
            bannerDao.save(bannerMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List activeBanner() {
        List list = bannerDao.findAllByStatus("Active");
        return list;
    }

    @Override
    public List getAllBanner() {
        return (List) bannerDao.findAll();
    }

    @Override
    public BannerMaster getBannerById(Integer bannerId) {
        BannerMaster bannerMaster = new BannerMaster();
        try {
            bannerMaster = bannerDao.findOne(bannerId);
            return bannerMaster;
        } catch (Exception e) {
            e.printStackTrace();
            return bannerMaster;
        }
    }
}
