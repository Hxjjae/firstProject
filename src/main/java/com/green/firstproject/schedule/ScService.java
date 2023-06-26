package com.green.firstproject.schedule;

import com.green.firstproject.schedule.model.ScEntity;
import com.green.firstproject.schedule.model.ScInsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScService {
    private final ScMapper mapper;


    public int insSc(ScInsDto dto) {
        ScEntity entity = new ScEntity();
        entity.setDescription(dto.getDescription());
        entity.setTitle(dto.getTitle());

        int result = mapper.insSc(entity);
        if (result == 1) {
            return entity.getIschedule();
        }
        return result;
    }
}
