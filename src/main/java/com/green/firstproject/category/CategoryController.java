package com.green.firstproject.category;

import com.green.firstproject.category.model.CategoryInsDto;
import com.green.firstproject.category.model.CategorySelDto;
import com.green.firstproject.category.model.CategoryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@Tag(name = "카테고리")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    @Operation(summary = "카테고리 추가")
    public int postCategory(@RequestBody CategoryInsDto dto) {
        return service.insCategory(dto);
    }

    @GetMapping("/allcategory")
    @Operation(summary = "카테고리 보기")
    public List<CategoryVo> getCategory() {
        return service.selCategory();
    }
    @GetMapping
    @Operation(summary = "카테고리 한개 보기", description = "" +
            "icategory : category 키값")
    public CategoryVo getCategoryById(@RequestParam int icategory) {
        CategorySelDto dto = new CategorySelDto();
        dto.setIcategory(icategory);
        return service.selCategoryById(dto);
    }
}

