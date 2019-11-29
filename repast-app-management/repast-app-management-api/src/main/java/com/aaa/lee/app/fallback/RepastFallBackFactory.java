package com.aaa.lee.app.fallback;

import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.*;
import com.aaa.lee.app.service.IRepastService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:41
 * @Description
 **/
@Component
public class RepastFallBackFactory implements FallbackFactory<IRepastService> {

    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService() {
            @Override
            public ResultData doComment(Integer memberId) {
                System.out.println("测试熔断方法");
                return null;
            }
            @Override
            public ResultData deleteComment(Integer id) {
                System.out.println("deleteComment测试");
                return null;
            }

            @Override
            public ResultData addComment(Integer shopId, Integer orderId, Integer productId, String memberNickName, String productName, Integer star, String memberIp,Integer showStatus, String productAttribute, Integer collectCouont, String pics, String memberIcon, Integer replayCount, String conent) {
                System.out.println("测试");
                return null;
            }

            @Override
            public String uploadHead(MultipartFile file) {
                System.out.println("getOrder测试");
                return null;
            }

            @Override
            public String upload(List<MultipartFile> file) {
                return null;
            }

            @Override
            public ResultData shopResult(Integer id) {
                return null;
            }

            @Override
            public ResultData doCommentReplay( Integer orderId) {
                System.out.println("回复熔断测试");
                return null;
            }

            @Override
            public Integer addCommentReplay(Integer commentId, String memberNickName, String memberIcon, String content,Integer type) {
                return null;
            }

            @Override
            public Integer doCount(Integer memberId) {
                return null;
            }


        };
        return repastService;
    }



}
