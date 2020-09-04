package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import com.example.demo.util.IpUtil;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/8/28 20:25
 */
@Controller
public class AllMediaController {
    private static final Logger logger = LoggerFactory.getLogger(AllMediaController.class);
    @Autowired
    private CommentService commentService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @ResponseBody
    @RequestMapping(value = "/addComment")
    public Map<String, String> addComment(@RequestParam(value = "content") String content,
                                          @RequestParam(value = "author_id") String author_id,
                                          @RequestParam(value = "article_id") String article_id,
                                          HttpServletRequest request) {
        String userIP = IpUtil.getIpAddr(request);
        Map<String, String> map = new HashMap<>();
        try {
            map = commentService.addComment(content, new BigInteger(author_id), userIP, new BigInteger(article_id));
            logger.info("添加成功");
        } catch (NumberFormatException e) {
            map.put("result", "N");
            map.put("message", "输入有误");
            logger.info("添加失败");
        }
        System.out.println(map);
        return map;

//        System.out.println(ip);
//        System.out.println(request.getParameter("content"));
//        System.out.println("评论内容是：" + content);
//        return new ModelAndView("world");
//        // 不写ResponseBody标记 return "world" 也可以

    }

    @RequestMapping(value = "/updateComment")
    @ResponseBody
    public Map<String, String> updateComment(@RequestParam(value = "newContent") String newContent,
                                          @RequestParam(value = "id") String id) {
        Map<String, String> map = new HashMap<>();
        try {
            map = commentService.updateComment(new BigInteger(id), newContent);
            logger.info("修改成功");
        } catch (NumberFormatException e) {
            map.put("result", "N");
            map.put("message", "输入有误");
            logger.info("修改失败");
            return map;
        }
        System.out.println(map);
        return map;

    }

    @RequestMapping(value = "/deleteComment")
    @ResponseBody
    public Map<String, String> deleteComment(@RequestParam(value = "id") String id) {
        Map<String, String> map = new HashMap<>();
        try {
            map = commentService.deleteComment(new BigInteger(id));
            logger.info("删除成功");
        } catch (NumberFormatException e) {
            map.put("result", "N");
            map.put("message", "输入有误");
            logger.info("删除失败");
            return map;
        }
        System.out.println(map);
        return map;

    }


    @RequestMapping(value = "/showComment")
    @ResponseBody
    public String showComment(@RequestParam(value = "author_id") String author_id) {
        Map<String, String> map = new HashMap<>();
        List<Comment> list = new ArrayList<>();
        try {
            list = commentService.showComment(new BigInteger(author_id));
        } catch (NumberFormatException e) {
            map.put("result", "N");
            map.put("message", "输入有误");
            logger.info("返回评论失败");
        }
        for (Comment comment : list) {
            System.out.println(comment.toString());

        }

        String json = JSON.toJSONString(list);
        System.out.println(json);

        return json;

    }





}
