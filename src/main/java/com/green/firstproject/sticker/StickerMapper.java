package com.green.firstproject.sticker;

import com.green.firstproject.sticker.model.StickerInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StickerMapper {
    int insSticker(StickerInsDto dto);
}
