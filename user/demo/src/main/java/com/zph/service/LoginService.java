package com.zph.service;


import com.zph.entity.Log;
import com.zph.entity.User;
import com.zph.mapper.LogMapper;
import com.zph.mapper.UserMapper;
import com.zph.tools.HashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired(required = false)
    LogMapper logMapper;
    public Map<String,String> login(String username,String password,int mod,Map<String,String> mapHttpHeader){
        Map<String,String> map=new HashMap<>();
        if(mod==0)/*电话登录*/
        {
            User currentUser=userMapper.selectByPhone(username);
            if(currentUser==null){
            map.put("result","登录失败");
            map.put("message","当前用户名不在，请注册");
            return map;
        }
           else if(HashCode.getHashCode(password).equals(currentUser.getPassword())){
                map.put("result","登录成功");
                map.put("message","无错误");
                Log log=new Log(1,mapHttpHeader.get("ip"),new Date(),"login by phone",mapHttpHeader.get("url"),mapHttpHeader.get("user-agent"));
                logMapper.insertLog(log);
                return map;

            }

            else{
                map.put("result","登录失败");
                map.put("message","密码错误，请重试");
                return map;

            }

        }
        else{/*email登录*/
          User currentUser=userMapper.selectByEmail(username);
            if(currentUser==null){
                map.put("result","登录失败");
                map.put("message","当前用户名不在，请注册");
                return map;
            }
          else if(HashCode.getHashCode(password).equals(currentUser.getPassword())){
              map.put("result","登录成功");
              map.put("message","无错误");
              Log log=new Log(1,mapHttpHeader.get("ip"),new Date(),"login by email",mapHttpHeader.get("url"),mapHttpHeader.get("user-agent"));
              logMapper.insertLog(log);
              return map;
          }
          else{
                map.put("result","登录失败");
                map.put("message","密码错误，请重试");
                return map;

            }

        }
    }


}
