package com.green.firstproject.timer;

import com.green.firstproject.timer.model.TimerInsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimerService {

    private final TimerMapper MAPPER;

    public int insTimer(TimerInsDto dto) {
        return MAPPER.insTimer(dto);
    }
}
