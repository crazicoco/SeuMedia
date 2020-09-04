package com.example.demo.dao;

import com.example.demo.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/8/28 20:39
 */
@Mapper
@Service
public interface CommentDao {
    void addComment(@Param("content") String content, @Param("author_id") BigInteger author_id, @Param("userIP") String userIP);

    List<Comment> selectByCreateBy(@Param("author_id") BigInteger author_id);

    void addArticleComment(@Param("article_id") BigInteger article_id, @Param("comment_id") BigInteger comment_id);

    void updateComment(@Param("id") BigInteger id, @Param("newContent") String newContent, @Param("time")Timestamp time);

    void deleteComment(@Param("id") BigInteger id);

    List<Comment> showComment(@Param("author_id") BigInteger author_id);


}
