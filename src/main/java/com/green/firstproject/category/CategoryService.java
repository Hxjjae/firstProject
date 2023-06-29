package com.green.firstproject.category;

import com.green.firstproject.category.model.CategoryInsDto;
import com.green.firstproject.category.model.CategorySelDto;
import com.green.firstproject.category.model.CategoryVo;
import com.green.firstproject.todo.model.SelCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryMapper mapper;

    public int insCategory(CategoryInsDto dto) {
        return mapper.insCategory(dto);
    }

    public List<CategoryVo> selCategory() {
        return mapper.selCategory();
    }

    public CategoryVo selCategoryById(CategorySelDto dto) {

        return mapper.selCategoryById(dto);
    }
}
