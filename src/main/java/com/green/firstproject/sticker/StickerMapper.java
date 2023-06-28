package com.green.firstproject.sticker;

import com.green.firstproject.sticker.model.StickerInsDto;
import com.green.firstproject.sticker.model.StickerSelDto;
import com.green.firstproject.sticker.model.StickerUpdDto;
import com.green.firstproject.sticker.model.StickerVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StickerMapper {
    int insSticker(StickerInsDto dto);
    int updSticker(StickerUpdDto dto);
    List<StickerVo> selSticker();
    int selStickerById(StickerSelDto dto);
}
