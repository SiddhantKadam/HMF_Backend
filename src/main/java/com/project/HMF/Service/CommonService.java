package com.project.HMF.Service;

import com.project.HMF.Dto.req.CommonLoginReqDto;
import com.project.HMF.Dto.res.CommonLoginResDto;

public interface CommonService {
    CommonLoginResDto commonLogin(CommonLoginReqDto commonLoginReqDto);
}
