package com.green.firstproject.badge;

import com.green.firstproject.badge.model.BadgeInsDto;
import com.green.firstproject.badge.model.BadgePicDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/badge")
public class BadgeController {
private final BadgeService service;

    public BadgeController(BadgeService service) {
        this.service = service;
    }
    @PostMapping
    public int insBadge(@RequestBody BadgeInsDto dto){
        return service.insBadge(dto);
    }
    @PatchMapping(name = "/pic", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE} )
    public int insPic(@RequestPart MultipartFile pic, @RequestParam int idx){
        BadgePicDto dto = new BadgePicDto();
        dto.setIbadge(idx);
        return service.insPic(pic,dto);
    }
}
