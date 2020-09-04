package com.zph.service;

import com.zph.entity.Log;
import com.zph.entity.User;
import com.zph.mapper.LogMapper;
import com.zph.mapper.UserInforMapper;
import com.zph.mapper.UserMapper;
import com.zph.tools.HashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class RegistService {

    @Autowired(required=false)
    private UserMapper userMapper;
    @Autowired(required=false)
    private LogMapper logMapper;
    @Autowired(required = false)
    private UserInforMapper userInforMapper;

    public Map<String,String> regist(User user, Map<String,String> mapHttpHeader){
        Map<String,String> map= new HashMap<>();
        User userPhone=userMapper.selectByPhone(user.getPhone());
        User userEmail=userMapper.selectByEmail(user.getEmail());
        if(userPhone==null&&userEmail==null){
            user.setPassword(HashCode.getHashCode(user.getPassword()));
            userMapper.insert(user);
            map.put("result","注册成功！");
            map.put("message","无错误");
            Log log=new Log(1,mapHttpHeader.get("ip"),new Date(),"regist",mapHttpHeader.get("url"),mapHttpHeader.get("user-agent"));
            logMapper.insertLog(log);
            User u=userMapper.selectByEmail(user.getEmail());
            userInforMapper.insertUserInfor(1,u.getId());
            return map;
        }
        else{
            map.put("result","注册失败！");
            map.put("message","信息已存在");
            return map;
        }

    }
}
