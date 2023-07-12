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



    public String upUserPic(MultipartFile pic, UserPicDto dto) {
        String centerPath = String.format("user/%d", dto.getIuser());
        String dicPath = String.format("%s/%s", FileUtils.getAbsolutePath(fileDir), centerPath);
        String temp = "0";
        File dic = new File(dicPath);
        if(!dic.exists()) {
            dic.mkdirs();
        }

        String originFileName = pic.getOriginalFilename();
        String savedFileName = FileUtils.makeRandomFileNm(originFileName);
        String savedFilePath = String.format("%s/%s", centerPath, savedFileName);
        String targetPath = String.format("%s/%s", FileUtils.getAbsolutePath(fileDir), savedFilePath);
        File target = new File(targetPath);
        try {
            pic.transferTo(target);
        } catch (Exception e) {
            return temp;
        }dto.setMainPic(savedFilePath);
        try {
            int result = mapper.upUserPic(dto);
            if (result == Integer.parseInt(temp)) {
                throw new Exception("스티커 사진 등록 불가");
            }
        } catch (Exception e) {
            target.delete();
            return temp;
        }
        return savedFilePath;
    }



    public int upAllUser(UserEntity entity) {
        return mapper.upAllUser(entity);
    }




    public List<UserListVo> selUser(UserListOneDto dto) {
        dto.setIuser(dto.getIuser());
        return mapper.selUser(dto);
    }

    public List<UserAllListVo> selAllUser() {
        return mapper.selAllUser();
    }


}
