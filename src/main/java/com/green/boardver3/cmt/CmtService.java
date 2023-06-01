package com.green.boardver3.cmt;

import com.green.boardver3.board.model.BoardDelDto;
import com.green.boardver3.cmt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private final CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }

    int insBoardCmt(BoardCmtEntity entity) {
        try {
            int result = mapper.insBoardCmt(entity);// 주소값을 복사했기때문에 값을 들고 올 수 있다. 값을 저장한값을 들고온다
            if (result == 1) {
                return entity.getIboardCmt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    List<BoardCmtVo> selCmt(BoardCmtDto dto){
        dto.setIdx((dto.getPage()-1)* dto.getRow());
        return mapper.selCmt(dto);
    }
    int delCmt(BoardCmtDeldto dto){
        return mapper.delCmt(dto);
    }

}



