package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.BoardCmtEntity;
import com.green.boardver3.cmt.model.CmtInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board/cmt")
public class CmtController {
    private final CmtService service; //널을 상수값으로 가질수 없기때문에 값을 무조건 넣어줘야한다. 생성자로 만들면 final을 값입력을 미룰수있다.

    @Autowired// di받기 위해서 사용
    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping
    public int postCmt(@RequestBody CmtInsDto dto) { // 필요없는값을 요구하지않고 딱 필요한 값만 입력할 수 있게 하기위해 entity를 굳이 해주지 않고 CmtInsDto를 사용해주었다. swagger 에 입력될 값
        return service.cmtIns(dto);
    }

}
