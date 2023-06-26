package com.green.firstproject.schedule;

import com.green.firstproject.schedule.model.ScEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScMapper {
    int insSc(ScEntity entity);
}
