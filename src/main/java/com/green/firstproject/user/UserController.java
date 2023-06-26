package com.green.firstproject.user;

import com.green.firstproject.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "프로필 등록")
public class UserController {
    private final UserService service;


    @PostMapping
    @Operation(summary = "프로필 등록", description = "name : 이름<br>"
            +"objective : 목표<br>")
    public int postUser(@RequestBody UserInsDto dto) {
        return service.insUser(dto);
    }

    @PutMapping
    @Operation(summary = "프로필 이름 수정")
    public int upNameUser(@RequestBody UserUpNameDto dto) {
        return service.upNameUser(dto);
    }





    @PutMapping("/profile")
    @Operation(summary = "프로필 목표 수정")
    public int putObjectviceUser(@RequestBody UserUpObjectiveDto dto) {
        return service.upObjectiveUser(dto);
    }



    @DeleteMapping
    @Operation(summary = "프로필 삭제")
    public int delUser(@RequestBody UserDelDto dto) {
        return service.delUser(dto);
    }




}
