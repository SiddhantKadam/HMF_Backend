package com.project.HMF.Controller;

import com.project.HMF.Model.CategoryMaster;
import com.project.HMF.Model.JobMaster;
import com.project.HMF.Service.CategoryService;
import com.project.HMF.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    private ResponseEntity create(@RequestBody JobMaster jobMaster) {
        boolean flag = jobService.jobCreate(jobMaster);
        if (flag) {
            return new ResponseEntity(flag, HttpStatus.OK);
        } else {
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    private ResponseEntity update(@RequestBody JobMaster jobMaster) {
        boolean flag = jobService.jobUpdate(jobMaster);
        if (flag) {
            return new ResponseEntity(flag, HttpStatus.OK);
        } else {
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    private ResponseEntity getAllJob() {
        List list = jobService.getAllJob();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/getById/{jobId}")
    private ResponseEntity getCategoryById(@PathVariable Integer jobId) {
        JobMaster jobMaster = jobService.getJobById(jobId);
        if (jobMaster != null) {
            return new ResponseEntity(jobMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity(jobMaster, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/activeJob")
    private ResponseEntity activeJob() {
        List list = jobService.activeJob();
        return new ResponseEntity(list, HttpStatus.OK);
    }

}
