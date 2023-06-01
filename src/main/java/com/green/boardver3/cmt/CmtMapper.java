package com.green.boardver3.cmt;

import com.green.boardver3.board.model.BoardDelDto;
import com.green.boardver3.cmt.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
   int insBoardCmt(BoardCmtEntity entity);
   List<BoardCmtVo> selCmt(BoardCmtDto dto);
   int delCmt(BoardCmtDeldto dto);
   int updCmt(BoardCmtEntity entity);
   int selMaxCmt(int num);

}
