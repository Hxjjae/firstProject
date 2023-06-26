package com.green.firstproject.user;

import com.green.firstproject.user.model.UserEntity;
import com.green.firstproject.user.model.UserInsDto;
import com.green.firstproject.user.model.UserUpDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;


    @PostMapping
    @Operation(summary = "프로필 등록")
    public int postUser(@RequestBody UserInsDto dto) {
        return service.insUser(dto);
    }

    @PutMapping
    @Operation(summary = "프로필 이름 수정")
    public int upUser(@RequestBody UserUpDto dto) {
        return service.upUser(dto);
    }

    @DeleteMapping
    @Operation(summary = "프로필 삭제")
    public int delUser(@RequestBody UserEntity entity) {
        return service.delUser(entity);
    }

    @GetMapping
    public


}
