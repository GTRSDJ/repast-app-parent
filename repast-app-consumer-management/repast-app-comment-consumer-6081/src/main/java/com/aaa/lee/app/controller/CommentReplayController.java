package com.aaa.lee.app.controller;


import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.CommentReplay;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@Api(value = "评论回复信息接口",tags = "评论回复信息详细接口")
public class CommentReplayController extends BaseController {
    @Autowired
    private IRepastService iRepastService;


    @GetMapping("/doCommentReplay")
    @ApiOperation(value = "查询评论回复",notes = "执行查询评论回复操作")
    ResultData doCommentReplay(@RequestParam("orderId") Integer orderId) {
        ResultData commentReplays = iRepastService.doCommentReplay(orderId);
        System.out.println("dkfhgg" + commentReplays);
        if (null != commentReplays) {
            return success("查询成功", commentReplays);
        } else {
            return failed();
        }

    }

        @GetMapping("/addCommentReplay")
        @ApiOperation(value = "评论回复",notes = "执行评论回复操作")
        ResultData addCommentReplay(@RequestParam("commentId") Integer commentId,@RequestParam("memberNickName") String memberNickName,
                                    @RequestParam("memberIcon") String memberIcon,@RequestParam("content") String content,
                                    @RequestParam("type") Integer type) {
             System.out.println("++++++++++++++++"+commentId);
            Integer i=iRepastService.addCommentReplay(commentId,memberNickName,memberIcon,content,type);
        if (i>0){
            return   success("回复成功");
          }else {
            return failed("回复失败");
           }

        }



}
