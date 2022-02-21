package com.project.HMF.Dto.req;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReportReqDto {

    private Date fromDate;
    private Date toDate;

}
