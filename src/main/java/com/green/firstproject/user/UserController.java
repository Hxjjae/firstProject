package com.green.firstproject.user;

import com.green.firstproject.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "프로필 등록")
public class UserController {
    private final UserService service;


    @PostMapping
    @Operation(summary = "프로필 이름등록", description = "name : 이름<br>"+"목표와 사진은 기본적으로 null값")
    public int postUser(@RequestBody UserInsDto dto) {
        return service.insUser(dto);
    }




    @PatchMapping(name = "/pic", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "프로필 사진 등록", description = "iuser : 유저 PK 값 ")
    public int patchPicUser(@RequestPart MultipartFile pic, @RequestParam int iuser) {
        UserPicDto dto = new UserPicDto();
        dto.setIuser(iuser);
        return service.upUserPic(pic, dto);
    }


    @PutMapping(value = "/profile")
    @Operation(summary = "프로필 이름, 목표 수정",description = "name : 이름<br>"+"ovjective : 목표<br>"+"iuser : 유저 pk값")
    public int allPutUser(@RequestBody UserAllDto dto) {

        return service.upAllUser(dto);
    }



    @GetMapping
    @Operation(summary = "유저 프로필 리스트 하나씩 확인" ,description = "iuser : 유저 pk값")
    public List<UserListVo> getUser(UserListOneDto dto) {
        return service.selUser(dto);
    }


    @GetMapping("/allList")
    @Operation(summary = "모든 유저 프로필 확인")
    public List<UserAllListVo> selAllUser() {
        return service.selAllUser();
    }

}
