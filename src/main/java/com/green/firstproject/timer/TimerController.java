package com.green.firstproject.timer;

import com.green.firstproject.timer.model.TimerInsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/timer")
public class TimerController {

    private final TimerService SERVICE;

    @PostMapping
    public int insTimer(@RequestBody TimerInsDto dto) {
        return SERVICE.insTimer(dto);
    }
}
