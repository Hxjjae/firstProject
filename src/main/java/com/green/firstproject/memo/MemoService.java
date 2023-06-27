package com.green.firstproject.memo;

import com.green.firstproject.memo.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private  final MemoMapper mapper;


    public int insMemo(MemoInsDto dto) {
        MemoEntity entity = new MemoEntity();
        entity.setCtnt(dto.getCtnt());
        entity.setTitle(dto.getTitle());
        entity.setIuser(dto.getIuser());

        int result = mapper.insMemo(entity);
        if (result == 1) {
            return entity.getImemo();
        }
        return  result;
    }

    public int upTileMemo(MemoUpTitleDto dto) {
        return mapper.upTileMemo(dto);
    }
    public int upCtntMemo(MemoUpCtntDto dto) {
        return mapper.upCtntMemo(dto);
    }

    public List<MemoListVo> selMemo(MemoListOneDto dto) {
        dto.setImemo(dto.getImemo());
        dto.setIuser(dto.getIuser());
        return mapper.selMemo(dto);
    }

    public List<MemoAllListVo> selAllMemo() {
        return mapper.selAllMemo();
    }

    public int delMemo(MemoDelDto dto) {

        return mapper.delMemo(dto);
    }
}
