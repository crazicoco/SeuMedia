package com.seumedia.demo01.controller;


import com.seumedia.demo01.entity.Article_Info;
import com.seumedia.demo01.service.ArticleManagerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.sound.midi.Track;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Controller
public class Articlecontroller {

    @Autowired
    ArticleManagerService articleManagerService;

    //    @ResponseBody
//    @RequestMapping("/hello")
//    public String Hello(){
//        return "Helloworld";
//    }
//
//    保证点击/index文件可以返回到index.html文件
    @RequestMapping("/index")
    public String index(Model model) { return "index"; }
    @RequestMapping(value="/modify")
    public String modify(Model model) { return "modify";}

    //文章内容的添加
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("message", "Type in info to add Article");
//        return "add_article_detail";
        return "add";
    }

    //    单纯的实现添加对于info表格的插入
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addArticle(@RequestParam(name = "version" ,required = true) int version,
                             @RequestParam(name = "title" , required = true) String title,
                             @RequestParam(name = "level" , required = true) byte level,
                             @RequestParam(name = "userid" , required = true) long userid,
                             Model model){
        Article_Info article_info = new Article_Info();
        long id =articleManagerService.article_maxid_return()+1;  //返回当前的最大id+1
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        article_info.setId(id);
        article_info.setUser_id(userid);
        article_info.setLevel(level);
        article_info.setVersion(version);
        article_info.setTitle(title);
        article_info.setCommited_by(timestamp);
        article_info.setModified_by(null);
        article_info.setPublished_by(null);
        article_info.setCreate_by(timestamp);
        article_info.setStatus(0);
        articleManagerService.saveArticle(article_info,null,null,null);
        model.addAttribute("message", "Successfully add one more article");
        return "add";
    }

//     在创建文章，修改文章的版本逻辑后进行更改
//    //write文章
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public Article_Info addArticle_info(@RequestParam(name = "version" ,required = true) int version,
//                             @RequestParam(name = "title" , required = true) String title,
//                             @RequestParam(name = "level" , required = true) byte level,
//                             @RequestParam(name = "userid" , required = true) long userid,
//                             Model model){
//        Article_Info article_info = new Article_Info();
//        long id =articleManagerService.article_maxid_return()+1;  //返回当前的最大id+1
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        article_info.setId(id);
//        article_info.setUser_id(userid);
//        article_info.setLevel(level);
//        article_info.setVersion(version);
//        article_info.setTitle(title);
//        article_info.setCommited_by(timestamp);
//        article_info.setModified_by(null);
//        article_info.setPublished_by(null);
//        article_info.setCreate_by(timestamp);
//        article_info.setStatus(0);
//        return article_info;
//    }
//    //撰写文章主体信息，然后返回给数据库
//    @RequestMapping(value = "/add_article_detail", method = RequestMethod.POST)
//    public String addArticle(){
//
//        return "add";
//    }
//

    //文章按照作者id分页显示


    //文章的删除操作
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Model model){
        model.addAttribute("message", "Type in info to delete Article");
        return "delete";
    }
    @RequestMapping(value = "delete", method = RequestMethod.POST)//删除某篇文章，依据文章id和文章版本信息
    public String deleteById_version(@RequestParam(value = "article_id", required = true) long id, @RequestParam(value = "article_version", required = true) long version, Model model){
        int h = articleManagerService.deletedById_verison(id,version);
        if (h!=-1) {
            model.addAttribute("message", "删除文章成功");
        }else{
            model.addAttribute("message", "查询无果或者删除失败");
        }
        return "delete";
    }


    //文章的查询操作
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model){
        List<Article_Info> article_infos = articleManagerService.getInfoAll();
        model.addAttribute("articleList", article_infos);
        List<Field> fields = Arrays.asList(Article_Info.class.getDeclaredFields());
        model.addAttribute("fields", fields);
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchById_version(@RequestParam(value = "id",required = true) long id, Model model){
       if(id==0){
           search(model);
       }
        List<Article_Info> article_infos = articleManagerService.getInfoAllById(id);
        model.addAttribute("articleList", article_infos);
        List<Field> fields = Arrays.asList(Article_Info.class.getDeclaredFields());
        model.addAttribute("fields", fields);
        return "search";
    }

}
