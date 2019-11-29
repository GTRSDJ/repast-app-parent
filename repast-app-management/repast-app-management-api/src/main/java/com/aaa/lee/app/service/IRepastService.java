package com.aaa.lee.app.service;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.CommentReplay;
import com.aaa.lee.app.fallback.RepastFallBackFactory;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

import java.util.List;
import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:40
 * @Description
 *      当使用feign进行传参的时候，如果是对象,包装类型,实体类...必须要使用@RequestBody，并且这个@RequestBody只能在该方法中出现一次
 *          ResultData selectUsersCondition(@RequestBody User user, @RequestBody UserInfo userInfo);---->错误
 *      当传递的参数是简单类型(String, Integer....8种基本类型+String)，必须要使用@RequestParam("")，这个@RequestPara注解可以出现多个
 *          ResultData selectUsersCondition(@RquestPara("username") String username, @RequestParam("age") Integer age);---->正确
 *
 **/
@FeignClient(value = "comment-replay",fallbackFactory = RepastFallBackFactory.class,configuration = IRepastService.MultipartSupportConfig.class)
public interface IRepastService {



     @GetMapping("/doComment")
    ResultData doComment(@RequestParam("memberId") Integer memberId);


    @GetMapping("/deleteComment")
    ResultData deleteComment(@RequestParam("id") Integer id);


    @GetMapping("/addComment")
    ResultData addComment(@RequestParam("shopId")  Integer shopId, @RequestParam("orderId") Integer orderId, @RequestParam("roductId") Integer productId,
                       @RequestParam("memberNickName") String memberNickName, @RequestParam("productName") String productName, @RequestParam("star") Integer star, @RequestParam("memberIp") String memberIp,
                       @RequestParam("showStatus") Integer showStatus, @RequestParam("productAttribute") String productAttribute, @RequestParam("collectCouont") Integer collectCouont,
                       @RequestParam("pics") String pics, @RequestParam("memberIcon") String memberIcon, @RequestParam("replayCount") Integer replayCount, @RequestParam("conent") String conent);

    /**
     * 单添加图片
     * @param file
     * @return
     */

    @PostMapping(value = "/uploadHead",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
      String uploadHead(@RequestPart MultipartFile file);




    @PostMapping(value = "/upload",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart List<MultipartFile>  file);
   /**
    * 根据 订单ID查点铺信息
    * @param id
    * @return
    */
   @GetMapping("/shop")
   ResultData shopResult(@RequestParam("shopId") Integer id);

    /***
     * 查询评价回复表
     * @param id
     * @param orderId
     * @return
     */

    @GetMapping("/doCommentReplay")
    ResultData doCommentReplay(@RequestParam("orderId") Integer orderId);

    /***
     * 评价回复表
     * @param commentReplay
     * @return
     */
    @PostMapping("/addCommentReplay")
    Integer addCommentReplay(@RequestParam("commentId") Integer commentId,@RequestParam("memberNickName") String memberNickName,
                             @RequestParam("memberIcon") String memberIcon,@RequestParam("content") String content,
                             @RequestParam("type") Integer type);




    @GetMapping("/doCount")
    Integer doCount(@RequestParam("memberId") Integer memberId);



    @Configuration
    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }





}




