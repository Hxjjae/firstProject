package com.green.firstproject.todo;

import com.green.firstproject.todo.model.TodoInsDto;
import com.green.firstproject.todo.model.TodoPacthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoMapper mapper;
@Autowired
    public TodoService(TodoMapper mapper) {
        this.mapper = mapper;
    }
    public int insTodo(TodoInsDto dto){

    return mapper.insTodo(dto);

    }
    public int patchSticker(TodoPacthDto dto){
    return mapper.patchSticker(dto);
    }
}
