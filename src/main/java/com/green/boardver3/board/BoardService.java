package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import com.green.boardver3.cmt.model.BoardCmtEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;

    @Autowired
    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public int insBoard(BoardInsDto dto) {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(dto.getTitle());
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());
        int result= mapper.insBoard(entity);
        if(result==1){
            return entity.getIboard(); // 이 작업이 어떤거고 아이보드 값을 리턴해준다는게 어떤 의미인지
        }
        return  result;
    }

    public List<BoardVo> selBoard(BoardSelDto dto) {
        int page = dto.getPage() - 1;
        dto.setIdx(page * dto.getRow());
        return mapper.selBoard(dto);
    }

    public int selBoardMaxPage(int row) {
        int count = mapper.selBoardRowCount();
        return (int) Math.ceil((double) count / row); //맥스값을 데리고 나눠주는건 이해했지만  int count =매퍼로 가져가라는걸 이해못함.. 인트가 어떻게 작용하지..?
    }

    public BoardDetailVo selBoardById(BoardIboardDto dto) {
        return mapper.selBoardById(dto);
    }

    public int delBoard(BoardDelDto dto) {
        return mapper.delBoard(dto);
    }

    public int updBoard(BoardUpdDto dto) {
        BoardCmtEntity entity = new BoardCmtEntity();
        return mapper.updBoard(dto);
    }
}

