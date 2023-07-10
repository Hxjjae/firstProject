package com.green.firstproject.todo;

import com.green.firstproject.todo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public int delTodo(TodoDelDto dto){
    TodoEntity entity = new TodoEntity();
    entity.setItodo(dto.getItodo());
        return mapper.delTodo(dto);
    }

    public int updTodo(TodoPutDto dto){
    return mapper.updTodo(dto);
    }

    public List<SelVo> selTodo(TodoSelDto dto){
    dto.setItodo(dto.getItodo());
    return mapper.selTodo(dto);
    }
    public List<SelUserVo> selUserTodo(SelUserDto dto){
    dto.setIuser(dto.getIuser());
            return mapper.selUserTodo(dto);
    }
    public List<SelAllVo> selAllTodo(){
    return mapper.selAllTodo();
    }
    public List<SelVo> UserCategorySel(SelCategoryDto dto){
        return mapper.UserCategorySel(dto);
    }

    public List<SelVo> selbyday(SelDayDto dto) {
    return mapper.Selbyday(dto);

    }
    public List<SelVo> Selbymonth(SelbymonthDto dto){
    return mapper.Selbymonth(dto);
    }
}
