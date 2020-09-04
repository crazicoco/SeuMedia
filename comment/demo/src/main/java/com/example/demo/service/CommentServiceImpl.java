package com.example.demo.service;

import com.example.demo.dao.CommentDao;
import com.example.demo.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/8/28 20:27
 */
@Component
public class CommentServiceImpl  implements CommentService{

    @Autowired
    CommentDao commentDao;

    //增加评论
    @Override
    public Map<String, String> addComment(String content, BigInteger author_id, String userIP, BigInteger article_id) {
        Map<String, String> map = new HashMap<>();
        try{
            commentDao.addComment(content, author_id, userIP);
            List<Comment> comments = commentDao.selectByCreateBy(author_id);
            Collections.reverse(comments);
            commentDao.addArticleComment(article_id, comments.get(0).getId());
        }catch (Exception e){
            map.put("result","N");
            map.put("message","插入失败");
            return map;
        }
        map.put("result","Y");
        map.put("message","插入成功");
        return map;
    }



    @Override
    public Map<String, String> updateComment(BigInteger id, String newContent) {
        Map<String, String> map = new HashMap<>();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Timestamp time = Timestamp.valueOf(formatter.format(now));
        try{
            commentDao.updateComment(id, newContent, time);
        }catch (Exception e){
            map.put("result","N");
            map.put("message","修改失败");
            return map;
        }
        map.put("result","Y");
        map.put("message","修改成功");
        return map;
    }

    @Override
    public Map<String, String> deleteComment(BigInteger id) {
        Map<String, String> map = new HashMap<>();
        try{
            commentDao.deleteComment(id);
        }catch (Exception e){
            map.put("result","N");
            map.put("message","删除失败");
            return map;
        }
        map.put("result","Y");
        map.put("message","删除成功");
        return map;
    }

    @Override
    public List<Comment> showComment(BigInteger id) {
        List<Comment> list =new ArrayList<>();
        try{
            list = commentDao.showComment(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
