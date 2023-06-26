package com.green.firstproject.user;

import com.green.firstproject.user.model.UserEntity;
import com.green.firstproject.user.model.UserUpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserEntity entity);
    int upUser(UserUpDto dto);
    int delUser(UserEntity entity);
}
