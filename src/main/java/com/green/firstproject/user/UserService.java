package com.green.firstproject.user;

import com.green.firstproject.user.model.*;
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
    public  int upNameUser(UserUpNameDto dto) {
        return mapper.upNameUser(dto);
    }


    public int upObjectiveUser(UserUpObjectiveDto dto) {
        return mapper.upObjectiveUser(dto);
    }

    public int delUser(UserDelDto dto) {
        return mapper.delUser(dto);
    }


}
