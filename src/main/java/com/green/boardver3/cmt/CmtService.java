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
                return entity.getIboardCmt(); // 등록이 되면 1을 입력해줘라 그리고 pk값이 1증가되므로 그걸 BoardCmtentity에 담아서 get으로 리턴할수있게해라 등록이 안되면 0을 띄워라.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
   public CmtRes selCmt(BoardCmtDto dto) {
       dto.setIdx((dto.getPage() - 1) * dto.getRow());
       List<BoardCmtVo> list = mapper.selCmt(dto);
        int count= mapper.selMaxCmt(dto.getIboard());
       int maxpage = (int) Math.ceil((double) count / dto.getRow());
       int ismore = 1;
       if (dto.getPage() == maxpage) {
           ismore = 0;
       }
       return CmtRes.builder()
               .maxpage(maxpage)
               .row(dto.getRow())
               .list(list)
               .isMore(ismore)
               .build();
   }

    public int delCmt(BoardCmtDeldto dto){
        return mapper.delCmt(dto);
    }

    int updCmt(BoardCmtEntity entity){
        return mapper.updCmt(entity);
    }
}



