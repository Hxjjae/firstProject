package com.green.firstproject.timer;

import com.green.firstproject.sticker.StickerService;
import com.green.firstproject.timer.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimerService {

    private final TimerMapper MAPPER;
    private final StickerService service;

    public int insTimer(TimerInsDto dto) {

        return MAPPER.insTimer(dto);
    }

    public int updTimer(TimerUpdDto dto) {
        return MAPPER.updTimer(dto);
    }

    public List<TimerVo> selTimerByDate(TimerEntity entity) {
        return MAPPER.selTimerByDate(entity);
    }
}
