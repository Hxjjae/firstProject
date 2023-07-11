package com.green.firstproject.user;

import com.green.firstproject.user.model.*;
import com.green.firstproject.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;


    @Value("${file.dir}")
    private String fileDir;


    public int insUser(UserInsDto dto) {
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());

        int result = mapper.insUser(entity);
        if (result == 1) {
            return entity.getIuser();
        }
        return result;

    }






    public int upAllUser(UserEntity entity) {
        return mapper.upAllUser(entity);
    }





    public List<UserAllListVo> selAllUser() {
        return mapper.selAllUser();
    }


}
