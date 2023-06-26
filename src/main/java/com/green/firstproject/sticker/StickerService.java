package com.green.firstproject.sticker;

import com.green.firstproject.sticker.model.StickerInsDto;
import com.green.firstproject.sticker.model.StickerSelDto;
import com.green.firstproject.sticker.model.StickerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StickerService {

    @Autowired
    private final StickerMapper mapper;

    int insSticker(StickerInsDto dto) {
        return mapper.insSticker(dto);
    }

    List<StickerVo> selSticker(StickerSelDto dto) {
        return mapper.selSticker(dto);
    }
}
