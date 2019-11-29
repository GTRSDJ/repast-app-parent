package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.CommentVo;
import com.aaa.lee.app.service.CommentService;
import com.aaa.lee.app.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



@RestController
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private PhotoController photoController;

    private Comment comment = new Comment();

    /**
     * 查询评价表
     *
     * @param id
     * @return
     */
    @GetMapping("/doComment")
    ResultData doComment(@RequestParam("memberId") Integer memberId) {
        List<CommentVo> doCommentList = commentService.doComment(memberId);
        Integer i = commentService.Count(memberId);
        if (null != doCommentList) {
            return success("查询成功", doCommentList);
        } else {
            return failed("查询失败");
        }
    }

    /**
     * 删除评价回复表
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteComment")
    ResultData deleteComment(@RequestParam("id") Integer id) {
        System.out.println("ppppp" + id);

        if (commentService.deleteComment(id) > 0) {
            return success("删除成功");
        } else {
            return failed("删除失败");
        }
    }

    /**
     * 添加评价
     *
     * @param comment
     * @return
     */
    @GetMapping("/addComment")
    ResultData addComment(@RequestParam("shopId") Integer shopId, @RequestParam("orderId") Integer orderId, @RequestParam("roductId") Integer productId,
                          @RequestParam("memberNickName") String memberNickName, @RequestParam("productName") String productName, @RequestParam("star") Integer star, @RequestParam("memberIp") String memberIp,
                          @RequestParam("showStatus") Integer showStatus, @RequestParam("productAttribute") String productAttribute, @RequestParam("collectCouont") Integer collectCouont,
                          @RequestParam("pics") String pics, @RequestParam("memberIcon") String memberIcon, @RequestParam("replayCount") Integer replayCount, @RequestParam("conent") String conent) {
        System.out.println("---------------------------" + shopId.byteValue());
        comment.setShopId(shopId.longValue());
        comment.setOrderId(orderId.longValue());
        comment.setProductId(productId.longValue());
        comment.setMemberNickName(memberNickName);
        comment.setProductName(productName);
        comment.setStar(star);
        comment.setMemberIp(memberIp);
        comment.setShowStatus(showStatus);
        comment.setProductAttribute(productAttribute);
        comment.setCollectCouont(collectCouont);
        comment.setPics(pics);
        comment.setMemberIcon(memberIcon);
        comment.setReplayCount(replayCount);
        comment.setContent(conent);
        commentService.addComment(comment);

        if (commentService.addComment(comment) > 0) {
            return success("添加成功");
        } else {
            return failed("添加失败");
        }
    }


    @GetMapping("/doCount")
    Integer doCount(@RequestParam("memberId") Integer memberId) {
        return commentService.Count(memberId);
    }


}