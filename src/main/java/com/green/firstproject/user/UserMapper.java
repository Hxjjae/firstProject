package com.green.firstproject.user;

import com.green.firstproject.user.model.UserDelDto;
import com.green.firstproject.user.model.UserEntity;
import com.green.firstproject.user.model.UserUpNameDto;
import com.green.firstproject.user.model.UserUpObjectiveDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserEntity entity);
    int upNameUser(UserUpNameDto dto);

    int upObjectiveUser(UserUpObjectiveDto dto);



    int delUser(UserDelDto dto);
}
