package com.green.boardver3.cmt;

import com.green.boardver3.board.model.BoardDelDto;
import com.green.boardver3.cmt.model.*;
import jakarta.validation.constraints.Min;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class CmtController {
    private final CmtService service; //널을 상수값으로 가질수 없기때문에 값을 무조건 넣어줘야한다. 생성자로 만들면 final을 값입력을 미룰수있다.

    @Autowired// di받기 위해서 사용
    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping("/{iboard}")
    public int postCmt(@PathVariable int iboard,@RequestBody BoardCmtInsDto dto) {
        BoardCmtEntity entity = new BoardCmtEntity();
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        entity.setIboard(iboard);
        return service.insBoardCmt(entity);
    }

    @GetMapping("/{iboard}/cmt")
    public CmtRes GetCmt(@RequestParam int page, @RequestParam (defaultValue = "5") int row, @PathVariable int iboard) {
        BoardCmtDto dto = new BoardCmtDto();
        dto.setPage(page);
        dto.setRow(row);
        dto.setIboard(iboard);
        return service.selCmt(dto);
    }
    @DeleteMapping("/cmt/{iboardCmt}")
    public int cmtDel(@PathVariable int iboardCmt ,@RequestParam int iuser){
        BoardCmtDeldto dto1 = new BoardCmtDeldto();
        dto1.setIboardcmt(iboardCmt);
        dto1.setIuser(iuser);
        System.out.println(dto1);
        return service.delCmt(dto1);
    }
    @PutMapping("/cmt/{iboardCmt}")
    public int cmtUpd(@PathVariable int iboardCmt,@RequestBody BoardCmtUpdDto dto ){
        BoardCmtEntity entity = new BoardCmtEntity();
        entity.setIboardCmt(iboardCmt);
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        return service.updCmt(entity);
    }



}

