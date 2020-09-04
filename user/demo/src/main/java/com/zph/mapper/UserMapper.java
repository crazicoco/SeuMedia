package com.zph.mapper;

import com.zph.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
        User selectByPrimaryKey(long id);
        User  selectByPhone(String phone);
        User selectByEmail(String email);
        int insert(User user);
        int updateByPhone(String phone);
        int updateByEmail(String email);

    }

