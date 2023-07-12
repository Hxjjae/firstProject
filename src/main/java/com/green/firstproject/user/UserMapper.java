package com.green.firstproject.user;

import com.green.firstproject.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser(UserEntity entity);



    int upAllUser(UserEntity entity);

    

    List<UserAllListVo> selAllUser(); //모든 리스트 보기

    List<String> selEmail();


    int upUserPic(UserPicDto dto);

    List<UserListVo> selUser(UserListOneDto dto);
}
