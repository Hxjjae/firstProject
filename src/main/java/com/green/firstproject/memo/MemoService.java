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

    public int upTileMemo(MemoEntity entity) {

        return mapper.upAllMemo(entity);
    }




    public List<MemoAllListVo> selAllMemo() {
        return mapper.selAllMemo();
    }

    public int delMemo(MemoDelDto dto) {

        return mapper.delMemo(dto);
    }

    public int delAllMemo() {
        return mapper.delAllMemo();
    }
}
