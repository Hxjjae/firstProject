package com.green.firstproject.schedule;

import com.green.firstproject.schedule.model.ScInsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScController {
    private final ScService service;

    @PostMapping
    public int postSc(@RequestBody ScInsDto dto) {
        return service.insSc(dto);
    }
}
