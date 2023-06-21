package com.green.firstproject.badge;

import com.green.firstproject.badge.model.BadgeInsDto;
import com.green.firstproject.badge.model.BadgePicDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BadgeMapper {
    int insBadge(BadgeInsDto dto);
    int insPic(BadgePicDto dto);
}
