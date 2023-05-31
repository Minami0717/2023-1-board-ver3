package com.green.boardver3.cmt;

import com.green.boardver3.board.model.BoardVo;
import com.green.boardver3.cmt.model.BoardCmtEntity;
import com.green.boardver3.cmt.model.CmtInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmtService {
    private final CmtMapper mapper;
    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }
    public int cmtIns(CmtInsDto dto){
        BoardCmtEntity entity = new BoardCmtEntity();
        entity.setIboard(dto.getIboard());
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());
        return mapper.insCmt(dto);
    }
}


