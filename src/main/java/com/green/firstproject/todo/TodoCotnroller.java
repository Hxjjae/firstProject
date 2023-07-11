package com.green.firstproject.todo;

import com.green.firstproject.todo.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@Tag(name = "게시글 작성")
public class TodoCotnroller {

    private final TodoService service;
@Autowired
    public TodoCotnroller(TodoService service) {
        this.service = service;
    }
    @PostMapping
    @Operation(summary = "게시글 작성 ", description = "name : 이름<br>"+"icategory : 카테고리 외래키값<br>" +"iuser 유저 외래키값<br>"+"ctnt: 내용<br>"+"title: 제목<br>")
    public int insTodo(@RequestBody TodoInsDto dto){
    return service.insTodo(dto);
    }

    @PatchMapping
    @Operation(summary = "스티커 수정", description = "itodo : 게시판pk값")
    public int patchSticker(@RequestBody TodoPacthDto dto){
    return service.patchSticker(dto);
    }

    @DeleteMapping
    @Operation(summary = "글 삭제", description = "itodo : 게시판 pk값")
    public int delTodo(@RequestParam int itodo){
    TodoDelDto dto = new TodoDelDto();
    dto.setItodo(itodo);
    return service.delTodo(dto);
    }

    @PutMapping
    @Operation(summary = "게시글 수정", description = "itodo : 게시판 pk값" +"icategory: 카테고리 외래키값")
    public int updTodo(@RequestBody TodoPutDto dto){
    return service.updTodo(dto);
    }

    @GetMapping
    @Operation(summary = "게시글 하나보기",description = "itodo: 게시판 pk값")
    public List<SelVo> selTodo(TodoSelDto dto){
    return service.selTodo(dto);
    }

    @GetMapping("/userboard")
    @Operation(summary = "유저가 쓴글 보기",description = "iuser : 유저의 기본키 todo에서는 외래키")
    public List<SelUserVo> selUserTodo(SelUserDto dto){
    return service.selUserTodo(dto);
    }

    @GetMapping("/allboard")
    @Operation(summary = "전체 글 보기")
    public List<SelAllVo> selAllTodo(){
        return service.selAllTodo();
    }
    @GetMapping("/category")
    @Operation(summary = "카테고리별 쓴글 보기",description = "icategory : 카테고리의 외래키<br>"+"iuser : user의 pk값 여기서는 외래키")
    public List<SelVo> UserCategorySel(@RequestParam int icategory, @RequestParam int iuser){

    SelCategoryDto dto = new SelCategoryDto();
    dto.setIcategory(icategory);
    dto.setIuser(iuser);
    return service.UserCategorySel(dto);
    }
    @GetMapping("/byday")
    @Operation(summary = "일 별로 출력(한달)")
    public List<SelVo> Selbyday(@RequestParam int day,@RequestParam int iuser){
    SelDayDto dto = new SelDayDto();
    dto.setDay(day);
    dto.setIuser(iuser);
    return service.selbyday(dto);
    }
    @GetMapping("/bymonth")
    @Operation(summary = "월 별로 출력")
    public List<SelVo> Selbymonth(@RequestParam int iuser,@RequestParam int month,@RequestParam int year,@RequestParam int day){
    SelbymonthDto dto =new SelbymonthDto();
    dto.setMonth(month);
    dto.setYear(year);
    dto.setDay(day);
    dto.setIuser(iuser);
    return service.Selbymonth(dto);
    }
}
