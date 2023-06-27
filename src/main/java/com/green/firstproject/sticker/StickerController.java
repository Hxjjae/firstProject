package com.green.firstproject.sticker;

import com.green.firstproject.sticker.model.StickerInsDto;
import com.green.firstproject.sticker.model.StickerSelDto;
import com.green.firstproject.sticker.model.StickerUpdDto;
import com.green.firstproject.sticker.model.StickerVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PatchMapping(name = "/추가", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE} )
    @Operation(summary = "스티커 수정")
    int patchSticker(@RequestPart MultipartFile pic
                    , @RequestParam int level) {
        StickerUpdDto dto = new StickerUpdDto();
        dto.setLevel(level);
        return service.updSticker(pic,dto);
    }

    @GetMapping
    @Operation(summary = "스티커 보기")
    List<StickerVo> getSticker() {
        return service.selSticker();
    }
}
