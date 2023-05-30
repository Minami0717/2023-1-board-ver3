package com.green.boardver3.user;

import com.green.boardver3.user.model.BoardUserInsDto;
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

    @Autowired
    public BoardUserController(BoardUserService service){
        this.service=service;
    }

    @PostMapping("/user")
    @Operation(summary = "회원가입",description = ""+
    "uid: [20] 회원아이디,<br>"+
    "upw: [100] 회원 비밀번호,<br>"+
    "nm: [30] 회원명,<br>"+
    "gender: [1] 성별(M: 남성, F: 여성),<br>"+
    "addr: [100] 대구시 달서구")
    public int postUser(@RequestBody BoardUserInsDto dto){
        return service.insUser(dto);
    }


}
