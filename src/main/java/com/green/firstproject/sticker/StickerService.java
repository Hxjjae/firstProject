package com.green.firstproject.sticker;

import com.green.firstproject.sticker.model.StickerInsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StickerService {

    @Autowired
    private final StickerMapper mapper;

    int insSticker(StickerInsDto dto) {
        return mapper.insSticker(dto);
    }
}
