package com.green.firstproject.badge;

import com.green.firstproject.badge.model.BadgeInsDto;
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
    public int insBadge(@RequestPart MultipartFile pic, @RequestBody BadgeInsDto dto){
        return service.insPic(dto);
    }
}
