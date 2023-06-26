package com.green.firstproject.sticker;

import com.green.firstproject.sticker.model.StickerInsDto;
import com.green.firstproject.sticker.model.StickerSelDto;
import com.green.firstproject.sticker.model.StickerVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sticker")
@RequiredArgsConstructor
@Tag(name = "스티커")
public class StickerController {

    @Autowired
    private final StickerService service;

    @PostMapping
    @Operation(summary = "스티커 추가")
    int postSticker(@RequestBody StickerInsDto dto) {
        return service.insSticker(dto);
    }

    @GetMapping
    @Operation(summary = "스티커 보기")
    List<StickerVo> getSticker(@RequestParam StickerSelDto dto) {
        service.selSticker(dto);
        List<StickerVo> list = new ArrayList<>();
        return list;
    }
}
