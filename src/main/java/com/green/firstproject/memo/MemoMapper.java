package com.green.firstproject.memo;

import com.green.firstproject.memo.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    int insMemo(MemoEntity entity);

    int upTileMemo(MemoUpTitleDto dto);

    int upCtntMemo(MemoUpCtntDto dto);

    List<MemoListVo> selMemo(MemoListOneDto dto); //메모 하나씩 보기

    List<MemoAllListVo> selAllMemo(); // 모든 메모 보기

    int delMemo(MemoDelDto dto);


}
