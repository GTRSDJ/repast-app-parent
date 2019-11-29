package com.aaa.lee.app.service;


import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.config.FtpProperties;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.mapper.CommentMapper;
import com.aaa.lee.app.utils.FileNameUtil;
import com.aaa.lee.app.utils.FtpUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/10/21 9:49
 * @Description
 **/
@Service
public class UploadService {

    @Autowired
    private FtpProperties ftpProperties;

    @Autowired
    private CommentMapper commentMapper;

    public String uploadHead(MultipartFile file) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        // 1.获取原始文件名(需要获取文件的后缀名)
        String oldFileName = file.getOriginalFilename();
        System.out.println("uploadService+"+oldFileName);
        try {
            // 2.生成新的文件名
                // id + 随机数 + 时间戳 作为新的文件名
                // 因为需要id，所以必须要从session中获取
                // getSession():是需要传参的，参数是Boolean，默认值为true
                // true和false有什么区别？
                // 如果传入值为true，在获取系统session的时候，如果session为null，也就是说系统中没有session则会默认自动创建一个
                // 如果传入的值为false，不会创建，直接返回为null
           // HttpSession session = request.getSession(false);
            //Comment user = (Comment)session.getAttribute("user");

           String id =UUID.randomUUID().toString();
           String Uid=id.replace("-","");


            String newFileName = FileNameUtil.getFileName(Uid);
            // 3.获取原始文件的后缀名
            String substring = oldFileName.substring(oldFileName.lastIndexOf("."));
            // 4.完成新的文件名
            newFileName = newFileName + substring;
            // 5.生成文件上传路径
            String filePath = new DateTime().toString("yyyy/MM/dd");

            // 6.调用上传工具类
            System.out.println(ftpProperties);
            System.out.println(ftpProperties.getHost());
            Boolean ifSuccess = FtpUtil.uploadFile(ftpProperties.getHost(), Integer.parseInt(ftpProperties.getPort()), ftpProperties.getUsername(),
                    ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newFileName, file.getInputStream());
            // 7.判断是否上传成功
            if(ifSuccess) {
                // 说明上传成功，把文件的路径和文件新的名称以及文件的原始名称更新进数据库
                // 通过id进行更新，也就是说只需要获取到headPicPath,newFilename,originalName就可以了
                // headPicPath:http://ip地址/2019/10/21/文件的新名称
                // http://ip地址:ftpProperties.getHttpPath()
                // 2019/10/21:filePath
                // 文件的新名称:newFileName;
                String headPicPath = ftpProperties.getHttpPath() + "/" + filePath + "/" + newFileName;
                System.out.println(headPicPath);
                return headPicPath;
              }
              return null;
           } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
