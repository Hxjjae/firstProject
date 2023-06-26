package com.green.firstproject.todo;

import com.green.firstproject.todo.model.TodoInsDto;
import com.green.firstproject.todo.model.TodoPacthDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoCotnroller {

    private final TodoService service;
@Autowired
    public TodoCotnroller(TodoService service) {
        this.service = service;
    }
@PostMapping
@Operation(summary = "게시글 작성")
    public int insTodo(TodoInsDto dto){
    return service.insTodo(dto);
    }
    @PatchMapping
    @Operation(summary = "스티커 수정")
    public int patchSticker(TodoPacthDto dto){
    return service.patchSticker(dto);
    }


}
