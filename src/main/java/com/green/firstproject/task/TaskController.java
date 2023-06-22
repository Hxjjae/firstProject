package com.green.firstproject.task;

import com.green.firstproject.task.model.TaskInsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private final TaskService service;

    @PostMapping
    public int postTask(@RequestBody TaskInsDto dto) {
        return service.insTask(dto);
    }
}
