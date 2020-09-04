package com.zph.controller;

import com.zph.tools.HashCode;
import com.zph.tools.HttpInfor;
import com.zph.entity.User;
import com.zph.service.LoginService;
import com.zph.service.RegistService;
import com.zph.service.UserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller   /*@RestController*/
@RequestMapping("/SEUMedia")
public class UserController {
    @Autowired
    private UserInforService userService;
    @Autowired
    private RegistService registService;
    @Autowired
    private LoginService loginService;

   /* @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.selectByPrimaryKey(id).toString();
    }*/

    /*@RequestMapping("getUser/{id}")
    public Map<String,Object> getUserInfor(@PathVariable long id){
        return userService.selectByPrimaryKey(id);

    }*/
    @RequestMapping("testJS")
    public String testFun(){
        System.out.println(HashCode.getHashCode("Hello world!"));
        return "testJS";
    }
    @RequestMapping("regist")
    public String registFromHtml(){
        return "regist";
    }

    @RequestMapping(value = "registFromHtml",method = RequestMethod.POST)//@RequestParam(value="username") String username,@RequestParam(value="password") String password,@RequestParam(value="phone") String phone,@RequestParam(value = "email")String email,
    public String regist(HttpServletRequest request,Model model)
    {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        Map<String,String> mapHttpHeader=HttpInfor.getHeadersInfo(request);
        //User user =new User(1,password,username,"wangeu",true,"123456778",new Date(),email,phone,"123","123","123",new Date(),new Date());
        User user =new User(1,username,password,email,phone,new Date(),new Date(), (byte) 0);
        Map<String,String> map= registService.regist(user,mapHttpHeader);
        model.addAttribute("result",map.get("result"));
        model.addAttribute("message",map.get("message"));
        model.addAttribute("from","来自注册界面的信息");
        return "display";

    }

    @RequestMapping("login")
    public String loginHtml(){
        //HttpInfor http=new HttpInfor();
       // Map <String,String>map=HttpInfor.getHeadersInfo(request);
       //System.out.println(map.get("user-agent"));
       //System.out.println(map.get("ip"));
     /*for(String key:map.keySet()){
          System.out.println("key:"+key+"  value:"+map.get(key));
     }*/   //遍历httpHeader所在的map
        return "login";
    }

    @RequestMapping(value = "loginFromHtml",method = RequestMethod.POST)//@RequestParam(value="username") String username, @RequestParam(value="password") String password,
    public String login( Model model,HttpServletRequest request)
    {
              /*mod:0 电话登录；mod:1 email登录*/
        String username=request.getParameter("username");
        String password =request.getParameter("password");
        Map<String,String> mapHttpHeader=HttpInfor.getHeadersInfo(request);
        String mailRex="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";  /*email正则表达式*/
        int mod;            /*记录登录方式 mod:0 电话登录；mod:1 email登录*/
        Pattern pattern=Pattern.compile(mailRex);
        Matcher matcher=pattern.matcher(username);
        if(matcher.matches()){ /*email*/
           mod=1;
        }
        else{  /*phone*/
            mod=0;
        }
        Map<String, String>  map=loginService.login(username,password,mod,mapHttpHeader);
        model.addAttribute("result",map.get("result"));
        model.addAttribute("message",map.get("message"));
        model.addAttribute("from","来自登录界面的信息");
        return "display";
    }


}
