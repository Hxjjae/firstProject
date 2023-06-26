package com.green.firstproject.todo;

import com.green.firstproject.todo.model.TodoInsDto;
import com.green.firstproject.todo.model.TodoPacthDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {
int insTodo(TodoInsDto dto);
int patchSticker(TodoPacthDto dto);
}
