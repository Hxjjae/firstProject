package com.green.firstproject.todo;

import com.green.firstproject.todo.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
int insTodo(TodoInsDto dto);
int patchSticker(TodoPacthDto dto);
int delTodo(TodoDelDto dto);
int updTodo(TodoPutDto dto);
List<SelVo> selTodo(TodoSelDto dto);
List<SelUserVo> selUserTodo(SelUserDto dto);
List<SelAllVo> selAllTodo();
List<SelVo> UserCategorySel(SelCategoryDto dto);
List<SelVo> Selbyday(SelDayDto dto);
List<SelVo> Selbymonth(SelbymonthDto dto);
}
