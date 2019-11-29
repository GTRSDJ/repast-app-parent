package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.CommentReplay;
import com.aaa.lee.app.domain.CommentVo;
import com.aaa.lee.app.service.CommentReplayService;
import com.aaa.lee.app.service.CommentService;
import com.aaa.lee.app.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
public class CommentReplayController extends BaseController {

   @Autowired
    private CommentReplayService commentReplayService;


    /**
     * 查询评价回复表
     * @param id
     * @return
     */
    @GetMapping("/doCommentReplay")
    ResultData doCommentReplay(@RequestParam("orderId") Integer orderId){

        System.out.println("jjcnjcj"+"----"+orderId);
        List<CommentReplay> CommentReplayList = commentReplayService.doCommentReplay(orderId);
          if (null!=CommentReplayList){
             return success("查询成功",CommentReplayList);
          }else {
             return failed("查询失败");
          }
      }

    /***
     * 评价回复
     * @param commentReplay
     * @return
     */

      @PostMapping("/addCommentReplay")
      Integer addCommentReplay(@RequestParam("commentId") Integer commentId,@RequestParam("memberNickName") String memberNickName,
                               @RequestParam("memberIcon") String memberIcon,@RequestParam("content") String content,
                               @RequestParam("type") Integer type) {

          System.out.println("+++++++"+commentId);

       CommentReplay commentReplay= new CommentReplay();
       commentReplay.setCommentId(commentId.longValue());
       commentReplay.setMemberNickName(memberNickName);
       commentReplay.setMemberIcon(memberIcon);
       commentReplay.setContent(content);
       commentReplay.setType(type);

      Integer result=commentReplayService.addCommentReplay(commentReplay);

      if (result>0){
          return  result;
      }
        return  null;
    }


    }
