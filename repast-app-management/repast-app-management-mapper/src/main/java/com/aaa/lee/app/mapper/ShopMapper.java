package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Order;
import com.aaa.lee.app.domain.Shop;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 12:12
 * @Description
 **/
@Repository
public interface ShopMapper extends Mapper<Shop> {


    Shop seleteAll(Integer id);


}
