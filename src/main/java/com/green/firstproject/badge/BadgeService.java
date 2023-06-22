package com.green.firstproject.badge;

import com.green.firstproject.badge.model.BadgeInsDto;
import com.green.firstproject.badge.model.BadgePicDto;
import com.green.firstproject.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class BadgeService {
    private final BadgeMapper mapper;
    @Value("D:/download/board3")
    private String fileDir;
@Autowired
    public BadgeService(BadgeMapper mapper) {
        this.mapper = mapper;
    }
    public int insBadge(BadgeInsDto dto){
    return mapper.insBadge(dto);
    }
    public int insPic(MultipartFile pic, BadgePicDto dto){
        String centerPath = String.format("user/%d", dto.getIbadge());
        String dicPath = String.format("%s/%s", fileDir, centerPath);

        File dic = new File(dicPath);
        if(!dic.exists()) {
            dic.mkdirs();
        }

        String originFileName = pic.getOriginalFilename();
        String savedFileName = FileUtils.makeRandomFileNm(originFileName);
        String savedFilePath = String.format("%s/%s", centerPath, savedFileName);
        String targetPath = String.format("%s/%s", fileDir, savedFilePath);
        File target = new File(targetPath);
        try {
            pic.transferTo(target);
        }catch (Exception e) {
            return 0;
        }
        dto.setPic(savedFilePath);
        try {
            int result = mapper.insPic(dto);
            if(result == 0) {
                throw new Exception("프로필 사진을 등록할 수 없습니다.");
            }
        } catch (Exception e) {
            //파일 삭제
            target.delete();
            return 0;
        }
        return 1;
    }
    }

