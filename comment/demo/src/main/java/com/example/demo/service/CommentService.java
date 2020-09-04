package com.example.demo.service;

import com.example.demo.entity.Comment;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/8/28 20:26
 */
public interface CommentService {
    Map<String, String> addComment(String content, BigInteger author_id, String userIP, BigInteger article_id);
    Map<String, String> updateComment(BigInteger id, String newContent);
    Map<String, String> deleteComment(BigInteger id);
    List<Comment>  showComment(BigInteger id);
}
