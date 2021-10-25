package com.project.HMF.Controller;

import com.project.HMF.Model.BannerMaster;
import com.project.HMF.Service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping
    private ResponseEntity create(@RequestBody BannerMaster bannerMaster) {
        boolean flag = bannerService.bannerCreate(bannerMaster);
        if (flag) {
            return new ResponseEntity(flag, HttpStatus.OK);
        } else {
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    private ResponseEntity bannerUpdate(@RequestBody BannerMaster bannerMaster) {
        boolean flag = bannerService.bannerUpdate(bannerMaster);
        if (flag) {
            return new ResponseEntity(flag, HttpStatus.OK);
        } else {
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    private ResponseEntity getAllBanner() {
        List list = bannerService.getAllBanner();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/getById/{bannerId}")
    private ResponseEntity getBannerById(@PathVariable Integer bannerId) {
        BannerMaster bannerMaster = bannerService.getBannerById(bannerId);
        if (bannerMaster != null) {
            return new ResponseEntity(bannerMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity(bannerMaster, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/activeBanner")
    private ResponseEntity activeBanner() {
        List list = bannerService.activeBanner();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
