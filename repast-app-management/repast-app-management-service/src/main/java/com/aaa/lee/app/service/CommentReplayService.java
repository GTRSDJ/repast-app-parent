package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.CommentReplay;
import com.aaa.lee.app.domain.CommentVo;
import com.aaa.lee.app.mapper.CommentMapper;
import com.aaa.lee.app.mapper.CommentReplayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class CommentReplayService extends BaseService<CommentReplay> {

    @Autowired
    private CommentReplayMapper commentReplayMapper;

    @Override
    public Mapper<CommentReplay> getMapper() {
        return commentReplayMapper;
    }

    /**
     * 查询
     * @return
     */
    public List<CommentReplay> doCommentReplay(Integer orderId){
        return commentReplayMapper.selectsAll(orderId);
    }


    /**
     * 添加
     * @return
     */
    public Integer addCommentReplay(CommentReplay commentReplay){


        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date=dateFormat.parse(dateFormat.format(new Date()));
            commentReplay.setCreateTime(date);
            return commentReplayMapper.insert(commentReplay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;

    }


}
