package com.green.boardver3.user;

import com.green.boardver3.user.model.BoardUserUpdDto;
import com.green.boardver3.user.model.BoardUserInsDto;
import com.green.boardver3.user.model.BoardUserLoginDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class BoardUserController {
    private final BoardUserService service;

    @Autowired
    public BoardUserController(BoardUserService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "회원가입", description = "" +
            "uid: [20] 회원아이디,<br>" +
            "upw: [100] 회원 비밀번호,<br>" +
            "nm: [30] 회원명,<br>" +
            "gender: [1] 성별(M: 남성, F: 여성),<br>" +
            "addr: [100] 대구시 달서구")
    public int postUser(@RequestBody BoardUserInsDto dto) {
        return service.insUser(dto);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "" +
            "리턴값: " +
            "(1)로그인 성공, " +
            "(2)아이디 없음, " +
            "(3)비밀번호 다름")
    public int postLoginUser(@RequestBody BoardUserLoginDto dto) {
        return service.login(dto);
    };

    @PatchMapping("/pw")
    public int patchUser(@RequestBody BoardUserUpdDto dto) {
        return service.updUser(dto);//
    }

}