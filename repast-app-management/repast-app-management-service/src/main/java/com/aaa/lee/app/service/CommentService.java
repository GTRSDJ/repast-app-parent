package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.CommentVo;
import com.aaa.lee.app.mapper.CommentMapper;
import com.aaa.lee.app.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 12:12
 * @Description
 **/
@Service
public class CommentService extends BaseService<Comment> {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Mapper<Comment> getMapper() {
        return commentMapper;
    }

    /**
     * 查询
     * @return
     */
    public List<CommentVo> doComment(Integer memberId){

        try {
            List<CommentVo> doCommentList = commentMapper.getseleteAll(memberId);
            if (null!=doCommentList){
                return doCommentList;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除
     * @param id
     * @return
     */

    public Integer deleteComment(Integer id){
        try {
           return super.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


   public  Integer addComment (Comment comment){
      SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
       try {
           Date date=dateFormat.parse(dateFormat.format(new Date()));
           comment.setCreateTime(date);
          return super.save(comment);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return  null;
   }

    /***
     * 评价数量
     */
   public  Integer Count(Integer memberId){
       try {
           return commentMapper.getCount(memberId);
       }catch (Exception e){
           e.printStackTrace();
       }
       return null;

   }



}
