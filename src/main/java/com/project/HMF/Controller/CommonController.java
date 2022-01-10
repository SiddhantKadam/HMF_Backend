package com.project.HMF.Controller;

import com.project.HMF.Dto.req.CommonLoginReqDto;
import com.project.HMF.Dto.res.CommonLoginResDto;
import com.project.HMF.Service.CategoryService;
import com.project.HMF.Service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @PostMapping(value = "/commonLogin")
    public ResponseEntity commonLogin(@RequestBody CommonLoginReqDto commonLoginReqDto)
    {
        CommonLoginResDto commonLoginResDto = commonService.commonLogin(commonLoginReqDto);
        return new ResponseEntity(commonLoginResDto, HttpStatus.OK);
    }
}
