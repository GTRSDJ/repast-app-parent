package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.CommentVo;
import com.aaa.lee.app.domain.Order;
import com.aaa.lee.app.service.CommentService;
import com.aaa.lee.app.service.UploadService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class PhotoController extends BaseController {

   @Autowired
    private CommentService commentService;

   @Autowired
   private UploadService uploadService;



    /***
     * 上传图片
     * @param file
     * @param request
     * @param orderCommentVo
     * @param commentReplayService
     * @return
     */
    @PostMapping(value = "/uploadHead",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadHead(@RequestPart MultipartFile file){ {
        System.out.println( "provider层"+file.getOriginalFilename());
        System.out.println( uploadService.uploadHead(file));
        return uploadService.uploadHead(file);
         }
       }

    /***
     * 多文件上传
     */


    @PostMapping(value = "/upload",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart List<MultipartFile> file) {
             String path="";
        System.out.println(file.size());
        for (MultipartFile fina : file) {
            System.out.println("provider层" + fina.getOriginalFilename());
            path= uploadService.uploadHead(fina);
            path=path+";";
        }
        String paths="";
        paths+=path;
        System.out.println("================"+paths);
        return paths;
    }

}
