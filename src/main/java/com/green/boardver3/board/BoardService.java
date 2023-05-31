package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
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
    public int insBoard(BoardInsDto dto){
    return mapper.insBoard(dto);
    }
    public List<BoardVo> selBoard(BoardSelDto dto){
        int page = dto.getPage()-1;
        dto.setIdx(page*dto.getRow());
        return mapper.selBoard(dto);
    }
    public int selBoardMaxPage(int row) {
        int count = mapper.selBoardRowCount(row);
        return (int)Math.ceil((double)count / row);
    }




}
