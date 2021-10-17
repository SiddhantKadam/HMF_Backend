package com.project.HMF.Service;

import com.project.HMF.Model.BannerMaster;

import java.util.List;

public interface BannerService {
    boolean bannerCreate(BannerMaster bannerMaster);

    boolean bannerUpdate(BannerMaster bannerMaster);

    List activeBanner();

    List getAllBanner();

    BannerMaster getBannerById(Integer bannerId);
}
