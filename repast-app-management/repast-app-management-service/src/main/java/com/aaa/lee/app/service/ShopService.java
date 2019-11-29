package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Shop;
import com.aaa.lee.app.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;


@Service
public class ShopService extends BaseService<Shop> {

   @Autowired
   private ShopMapper shopMapper;


    public Mapper<Shop> getMapper() {
        return shopMapper;
    }


    /***
     * 根据ID查询店铺信息
     * @param id
     * @return
     */

    public Shop shopAll(Integer id) {

        try {
            return shopMapper.seleteAll(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
