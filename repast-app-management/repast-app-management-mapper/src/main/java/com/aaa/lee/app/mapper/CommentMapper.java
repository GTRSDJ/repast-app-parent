package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.CommentVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 12:12
 * @Description
 **/
@Repository
public interface CommentMapper extends Mapper<Comment> {

     List<CommentVo> getseleteAll(Integer memberId);
     int getCount(Integer id);


}
