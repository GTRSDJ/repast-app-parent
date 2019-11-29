package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.CommentReplay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public interface CommentReplayMapper extends Mapper<CommentReplay> {


    List<CommentReplay> selectsAll(@Param("orderId") Integer orderId);

}