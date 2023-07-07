package com.green.firstproject.timer;

import com.green.firstproject.timer.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TimerMapper {
    int insTimer(TimerInsDto dto);
    int updTimer(TimerUpdDto dto);
    List<TimerVo> selTimerByDate(TimerEntity entity);
}
