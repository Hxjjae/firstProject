package com.green.firstproject.memo;

import com.green.firstproject.memo.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memo")
@RequiredArgsConstructor
@Tag(name = "메모장")
public class MemoController {
    private final MemoService service;

    @PostMapping
    @Operation(summary = "메모장 타이틀, 내용 등록")
    public int postMemo(@RequestBody MemoInsDto dto) {
        return service.insMemo(dto);
    }

    @PatchMapping("/title")
    @Operation(summary = "메모장 타이틀 수정" ,description = "imemo : 메모장 PK값")
    public int patchTileMemo(@RequestBody MemoUpTitleDto dto) {
        return service.upTileMemo(dto);
    }

    @PatchMapping("/ctnt")
    @Operation(summary = "메모장 내용 수정",description = "imemo : 메모장 PK값")
    public int patchCtntMemo(@RequestBody MemoUpCtntDto dto) {
        return service.upCtntMemo(dto);
    }

    @GetMapping
    @Operation(summary = "메모 하나씩 보기")
    public List<MemoListVo> selMemo(MemoListOneDto dto) {
        return service.selMemo(dto);
    }

    @GetMapping("/allMemo")
    @Operation(summary = "모든 메모 보기")
    public List<MemoAllListVo> selAllMemo() {
        return service.selAllMemo();
    }

    @DeleteMapping
    @Operation(summary = "메모 삭제")
    public int delMemo(@RequestBody MemoDelDto imemo) {
        return service.delMemo(imemo);
    }

}
