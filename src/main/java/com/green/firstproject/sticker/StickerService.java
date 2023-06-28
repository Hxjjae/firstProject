package com.green.firstproject.sticker;

import com.green.firstproject.sticker.model.StickerInsDto;
import com.green.firstproject.sticker.model.StickerSelDto;
import com.green.firstproject.sticker.model.StickerUpdDto;
import com.green.firstproject.sticker.model.StickerVo;
import com.green.firstproject.utils.CommonUtils;
import com.green.firstproject.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StickerService {

    private final StickerMapper mapper;
    private final CommonUtils commonUtils;
    @Value("${file.dir}")
    private String fileDir;

    int insSticker(StickerInsDto dto) {
        return mapper.insSticker(dto);
    }

    int updSticker(MultipartFile pic, StickerUpdDto dto) {
        String centerPath = String.format("sticker/%d", dto.getIsticker());
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
        } catch (Exception e) {
            return 0;
        }dto.setPic(savedFilePath);
        try {
            int result = mapper.updSticker(dto);
            if (result == 0) {
                throw new Exception("스티커 사진 등록 불가");
            }
        } catch (Exception e) {
            target.delete();
            return 0;
        }
        return 1;
    }

    List<StickerVo> selSticker() {
        return mapper.selSticker();
    }

    int selStickerById(StickerSelDto dto) {
        return mapper.selStickerById(dto);
    }
}
