package com.green.firstproject.todo;

import com.green.firstproject.todo.model.TodoDelDto;
import com.green.firstproject.todo.model.TodoInsDto;
import com.green.firstproject.todo.model.TodoPacthDto;
import com.green.firstproject.todo.model.TodoPutDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
@Tag(name = "게시글 작성")
public class TodoCotnroller {

    private final TodoService service;
@Autowired
    public TodoCotnroller(TodoService service) {
        this.service = service;
    }
    @PostMapping
    @Operation(summary = "게시글 작성")
    public int insTodo(@RequestBody TodoInsDto dto){
    return service.insTodo(dto);
    }

    @PatchMapping
    @Operation(summary = "스티커 수정")
    public int patchSticker(@RequestBody TodoPacthDto dto){
    return service.patchSticker(dto);
    }

    @DeleteMapping
    @Operation(summary = "글 삭제")
    public int delTodo(@RequestParam int itodo){
    TodoDelDto dto = new TodoDelDto();
    dto.setItodo(itodo);
    return service.delTodo(dto);
    }
    @PutMapping
    @Operation(summary = "게시글 수정")
    public int updTodo(@RequestBody TodoPutDto dto){
    return service.updTodo(dto);
    }

}
