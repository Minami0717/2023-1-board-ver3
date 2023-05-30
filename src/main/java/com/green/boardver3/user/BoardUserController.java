package com.green.boardver3.user;

import com.green.boardver3.user.model.BoardUserInsDto;
import com.green.boardver3.utils.CommonUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BoardUserController {
    private final BoardUserService service;
    private final CommonUtils commonUtils;

    @Autowired
    public BoardUserController(BoardUserService service, CommonUtils commonUtils){
        this.service=service;
        this.commonUtils = commonUtils;
    }

    @PostMapping("/user")
    @Operation(summary = "회원가입",description = ""+
    "uid: [20] 회원아이디,<br>"+
    "upw: [100] 회원 비밀번호,<br>"+
    "nm: [30] 회원명,<br>"+
    "gender: [1] 성별(M: 남성, F: 여성),<br>"+
    "addr: [100] 대구시 달서구")
    public int postUser(@RequestBody BoardUserInsDto dto){
//        String upw = dto.getUpw();
//        String changeUpw = commonUtils.encodeSha256(upw);
//        dto.setUpw(changeUpw);

        dto.setUpw(commonUtils.encodeSha256(dto.getUpw()));
        return service.insUser(dto);
    }
}
