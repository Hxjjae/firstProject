package com.green.firstproject.user;

import com.green.firstproject.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser(UserEntity entity);

    int upUserPic(UserPicDto dto);

    int upAllUser(UserEntity entity);

    List<UserListVo> selUser(UserListOneDto dto); // 리스트 하나씩 보기

    List<UserAllListVo> selAllUser(); //모든 리스트 보기

    List<String> selEmail();

}
