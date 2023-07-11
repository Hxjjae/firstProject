package com.green.firstproject.timer;

import com.green.firstproject.timer.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timer")
@Tag(name = "타이머")
@RequiredArgsConstructor

public class TimerController {

    private final TimerService SERVICE;

    @PostMapping
    @Operation(summary = "타이머 추가", description = "" +
            "studyLine : 공부한시간<br>" +
            "iuser : user 키값<br>")
    public int insTimer(@RequestBody TimerInsDto dto) {
        return SERVICE.insTimer(dto);
    }

    @PatchMapping
    @Operation(summary = "타이머 수정 및 스티커 추가", description = "" +
            "iuser : user 키값<br>" +
            "itimer : 타이머 키값<br>" +
            "studyLine : 공부한시간")
    public int patchTimer(@RequestBody TimerUpdDto dto) {
        return SERVICE.updTimer(dto);
    }

    @GetMapping
    @Operation(summary = "유저 별 시간 및 스티커 가져오기")
    public List<TimerVo> selTimerByDate(@RequestParam int iuser, @RequestParam int month) {
        TimerEntity entity = new TimerEntity();
        entity.setIuser(iuser);
        entity.setMonth(month);
        return SERVICE.selTimerByDate(entity);
    }
}
