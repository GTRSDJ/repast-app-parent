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

import java.util.List;
import java.util.Map;


@RestController
@Api(value = "店铺信息接口",tags = "店铺信息详细接口")
public class ShopController extends BaseController {
    @Autowired
    private IRepastService iRepastService;

    @ApiOperation(value = "评论",notes = "执行评论操作")
    @GetMapping("/shop")
    ResultData shopResult(@RequestParam("id") Integer id){
        iRepastService.shopResult(id);

        if (null!=iRepastService.shopResult(id)){
           return iRepastService.shopResult(id);
       }else {
           return null;
       }
    }




}
