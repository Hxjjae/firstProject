package com.green.firstproject.user;

import com.green.firstproject.user.model.UserEntity;
import com.green.firstproject.user.model.UserInsDto;
import com.green.firstproject.user.model.UserUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;


    public int insUser(UserInsDto dto) {
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());

        int result = mapper.insUser(entity);
        if (result == 1) {
            return entity.getIuser();
        }
        return result;

    }
    public  int upUser(UserUpDto dto) {
        return mapper.upUser(dto);
    }

    public int delUser(UserEntity entity) {
        return mapper.delUser(entity);
    }


}
