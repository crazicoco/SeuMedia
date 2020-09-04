package com.zph.mapper;

import com.zph.entity.Log;
import com.zph.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    int insertLog(Log log);
    int deleteLog(long id);
    int updateById(long id);
    User selectById(long id);
}
