package com.zph.service;


import com.zph.entity.User;
import com.zph.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserInforService {

@Autowired(required=false)
private UserMapper userMapper;
public Map<String,Object> selectByPrimaryKey(long id) {
    User user=userMapper.selectByPrimaryKey(id);
    Map<String,Object> map=new HashMap<>();
    if(user!=null){
        map.put("result","success");
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());

        return map;
    }
    else{
        map.put("result","fail");
        map.put("message","信息不存在");
        return map;
    }
    }
}
