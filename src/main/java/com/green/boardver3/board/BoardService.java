package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import com.green.boardver3.cmt.CmtMapper;
import com.green.boardver3.cmt.model.BoardCmtDeldto;
import com.green.boardver3.cmt.model.BoardCmtEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;
    private  final CmtMapper cmtMapper;

    @Autowired
    public BoardService(BoardMapper mapper, CmtMapper cmtMapper) {
        this.cmtMapper=cmtMapper;
        this.mapper = mapper;
    }

    public int insBoard(BoardInsDto dto) {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(dto.getTitle());
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());
        int result= mapper.insBoard(entity);
        if(result==1){
            return entity.getIboard();
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
        return (int) Math.ceil((double) count / row); //정신 차리라
    }

    public BoardDetailVo selBoardById(BoardIboardDto dto) {
        return mapper.selBoardById(dto);
    }

    @Transactional(rollbackFor = Exception.class)
    public int delBoard(BoardDelDto dto) throws Exception {
        BoardCmtDeldto cmtDto = new BoardCmtDeldto();
        cmtDto.setIboard(dto.getIboard());
        cmtMapper.delCmt(cmtDto);
        // 그 글에 달려있는 댓글을 전부 삭제해야 함.
        int result = 0;
        result = mapper.delBoard(dto);
        if (result == 0) {
            throw new Exception("삭제 권한 없음");
        }
        return result;
    }

    public int updBoard(BoardUpdDto dto) {
        BoardCmtEntity entity = new BoardCmtEntity();
        return mapper.updBoard(dto);
    }
}

