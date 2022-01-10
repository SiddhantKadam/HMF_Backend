package com.project.HMF.Configuration;

import com.project.HMF.Dto.res.FileUploadResDto;
import org.apache.tomcat.util.http.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;


@CrossOrigin(value = "*")
@RestController
@MultipartConfig(maxFileSize = 1024*1024*1024*1024*1024, maxRequestSize = 1024*1024*1024*1024*1024)
public class AwsController {

    @Autowired
    private AmazonClient amazonClient;

    public void setAmazonClient(AmazonClient amazonClient)
    {
        this.amazonClient = amazonClient;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity uploadFile(@RequestParam(value = "uploadfile") MultipartFile file) throws FileSizeLimitExceededException{


        try{
            String s = file.getOriginalFilename();
            String extension = s.substring(s.lastIndexOf(".") + 1);

            if (extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("gif") || extension.equalsIgnoreCase("jpeg")) {
                System.out.println(file.getSize());
                if (file.getSize() < 1e+6) {
                    FileUploadResDto fileUploadResDto = new FileUploadResDto();
                    String str = this.amazonClient.uploadFile(file);
                    System.out.print(str);
                    if (str != null && !str.equalsIgnoreCase("")) {

                        fileUploadResDto.setPath(str);
                        fileUploadResDto.setStatus(true);
                        return new ResponseEntity(fileUploadResDto, HttpStatus.OK);
                    } else {
                        fileUploadResDto.setStatus(true);
                        return new ResponseEntity(fileUploadResDto, HttpStatus.OK);
                    }
                }
                else
                {
                    FileUploadResDto fileUploadResDto = new FileUploadResDto();
                    fileUploadResDto.setStatus(false);
                    fileUploadResDto.setPath("Image size exceed (max limit 1 MB)");
                    return new ResponseEntity(fileUploadResDto, HttpStatus.OK);
                }
            }
            else
            {
                FileUploadResDto fileUploadResDto = new FileUploadResDto();
                fileUploadResDto.setStatus(false);
                fileUploadResDto.setPath("Upload Image Only");
                return new ResponseEntity(fileUploadResDto, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FileUploadResDto fileUploadResDto = new FileUploadResDto();
            fileUploadResDto.setStatus(false);
            fileUploadResDto.setPath("Upload Faield");
            return new ResponseEntity(fileUploadResDto, HttpStatus.OK);
        }

    }
}