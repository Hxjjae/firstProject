package com.green.firstproject.task;

import com.green.firstproject.task.model.TaskEntity;
import com.green.firstproject.task.model.TaskInsDto;
import com.green.firstproject.task.model.TaskUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping
    public int patchTask(@RequestParam Long itask,
                         @RequestBody TaskUpdDto dto) {
        TaskEntity entity = new TaskEntity();
        entity.setItask(itask);
        return service.updTask(dto);
    }
}
