package com.green.firstproject.todo;

import com.green.firstproject.todo.model.TodoDelDto;
import com.green.firstproject.todo.model.TodoInsDto;
import com.green.firstproject.todo.model.TodoPacthDto;
import com.green.firstproject.todo.model.TodoPutDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {
int insTodo(TodoInsDto dto);
int patchSticker(TodoPacthDto dto);
int delTodo(TodoDelDto dto);
int updTodo(TodoPutDto dto);
}
