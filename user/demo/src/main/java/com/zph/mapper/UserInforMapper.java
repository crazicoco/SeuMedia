package com.zph.mapper;

import com.zph.entity.UserInfor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInforMapper {

    UserInfor select(long id);
    int delete(long id);
    int insertUserInfor(long id ,@Param("userId") long user_id);/*@Param("userId") 要和UserInforMapper.xml文件里的SQL语句变量对应；*/
}
