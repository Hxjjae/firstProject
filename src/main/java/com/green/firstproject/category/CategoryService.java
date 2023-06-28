package com.green.firstproject.category;

import com.green.firstproject.category.model.CategoryInsDto;
import com.green.firstproject.category.model.CategoryVo;
import lombok.RequiredArgsConstructor;
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
}