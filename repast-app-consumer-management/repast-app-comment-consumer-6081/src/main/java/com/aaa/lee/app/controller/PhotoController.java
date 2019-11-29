package com.aaa.lee.app.controller;


import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;


@RestController
@Api(value = "上传图片接口",tags = "上传图片详细接口")
public class PhotoController extends BaseController {
    @Autowired
    private IRepastService iRepastService;



    @PostMapping(value = "/uploadHead")
    @ApiOperation(value = "图片上传接口",notes = "执行图片上传接口操作")
    String uploadHead(@RequestPart("file") MultipartFile file){
        System.out.println( "consumer层"+file.getOriginalFilename());
        return  iRepastService.uploadHead(file);
    }


    @ApiOperation(value = "多图片上传接口",notes = "执行图片上传接口操作")
    @PostMapping(value = "/upload",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart List<MultipartFile> file){

        System.out.println("consumer"+ "-------"+file.size());
        return  iRepastService.upload(file);
    }


    @GetMapping(value = "/upl")
    public  ModelAndView DDD(ModelAndView  mv){

        mv.setViewName("upload_head");
        return mv;

    }


}
