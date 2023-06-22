package com.green.firstproject.task;

import com.green.firstproject.task.model.TaskInsDto;
import com.green.firstproject.task.model.TaskUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TaskService {

    @Autowired
    private final TaskMapper mapper;

    public int insTask(TaskInsDto dto) {
        return mapper.insTask(dto);
    }

    public int updTask(TaskUpdDto dto) {
        return mapper.updTask(dto);
    }
}
