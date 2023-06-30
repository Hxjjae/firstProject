package com.green.firstproject.timer;

import com.green.firstproject.timer.model.TimerInsDto;
import com.green.firstproject.timer.model.TimerUpdDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimerMapper {
    int insTimer(TimerInsDto dto);
    int updTimer(TimerUpdDto dto);
}
