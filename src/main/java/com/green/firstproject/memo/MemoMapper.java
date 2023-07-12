package com.green.firstproject.memo;

import com.green.firstproject.memo.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    int insMemo(MemoEntity entity);

    int upAllMemo(MemoEntity entity);




    List<MemoAllListVo> selAllMemo(); // 모든 메모 보기

    int delMemo(MemoDelDto dto);

    int delAllMemo();


}
