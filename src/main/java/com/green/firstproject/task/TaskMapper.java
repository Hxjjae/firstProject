package com.green.firstproject.task;

import com.green.firstproject.task.model.TaskInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {
    int insTask(TaskInsDto dto);

}
