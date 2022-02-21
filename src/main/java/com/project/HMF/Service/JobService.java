package com.project.HMF.Service;

import com.project.HMF.Model.JobMaster;

import java.util.List;

public interface JobService {
    boolean jobCreate(JobMaster jobMaster);

    boolean jobUpdate(JobMaster jobMaster);

    List getAllJob();

    JobMaster getJobById(Integer jobId);

    List activeJob();
}
