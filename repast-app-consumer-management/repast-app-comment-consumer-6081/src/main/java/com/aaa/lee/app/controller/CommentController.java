package com.aaa.lee.app.controller;


import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.*;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@Api(value = "评论信息接口",tags = "评论信息详细接口")
public class CommentController extends BaseController {
    @Autowired
    private IRepastService iRepastService;

    @GetMapping("/do")
    @ApiOperation(value = "评论",notes = "执行评论操作")
    public ResultData doComment(@RequestParam("memberId") Integer memberId){
        ResultData commentVos = iRepastService.doComment(memberId);
        System.out.println("kjsdhnsk"+commentVos);
        if (null!=commentVos){
           return success("查询成功",commentVos);
       }else {
           return failed();
       }
    }


    @GetMapping("/delete")
    @ApiOperation(value = "删除评论",notes = "执行删除评论操作")
    public ResultData deleteComment(@RequestParam("id") Integer id) {
        System.out.println("cccccccccccc"+id);
        if (null != iRepastService.deleteComment(id)) {
            return success("删除成功");
        } else {
            return failed();
        }
    }

        @GetMapping("/addComment")
        @ApiOperation(value = "添加数据接口",notes = "执行添加订单数据接口操作")
       ResultData addComment(@RequestParam("shopId")  Integer shopId, @RequestParam("orderId") Integer orderId, @RequestParam("roductId") Integer productId,
                          @RequestParam("memberNickName") String memberNickName, @RequestParam("productName") String productName, @RequestParam("star") Integer star, @RequestParam("memberIp") String memberIp,
                          @RequestParam("showStatus") Integer showStatus, @RequestParam("productAttribute") String productAttribute, @RequestParam("collectCouont") Integer collectCouont,
                          @RequestParam("pics") String pics, @RequestParam("memberIcon") String memberIcon, @RequestParam("replayCount") Integer replayCount, @RequestParam("conent") String conent){

            System.out.println("skjdbgvjdgbfbfkb"+shopId);
            ResultData resultData=iRepastService.addComment(shopId,orderId, productId, memberNickName, productName,star,memberIp,
                    showStatus,productAttribute, collectCouont,
                    pics, memberIcon, replayCount,conent);

            if ("400"!=resultData.getCode()) {
                return success("添加成功");
            } else {
                return failed("添加失败");
            }
    }

    /***
     * 查询评价数目
     * @param memberId
     * @return
     */
    @GetMapping("/doCount")
    @ApiOperation(value = "评价数目接口",notes = "执行评价数目接口操作")
    ResultData doCount(@RequestParam("memberId") Integer memberId){
        return success("查询成功",iRepastService.doCount(memberId));


    }



}
