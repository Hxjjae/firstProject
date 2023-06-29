package com.green.firstproject.category;

import com.green.firstproject.category.model.CategoryInsDto;
import com.green.firstproject.category.model.CategorySelDto;
import com.green.firstproject.category.model.CategoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    int insCategory(CategoryInsDto dto);
    List<CategoryVo> selCategory();
    CategoryVo selCategoryById(CategorySelDto dto);
}
