package com.green.boardver3.user;

import com.green.boardver3.user.model.BoardUserInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BoardUserController {
    private BoardUserService service;

    @Autowired
    public BoardUserController(BoardUserService service){
        this.service=service;
    }

    @PostMapping("/user")
    public int postUser(@RequestBody BoardUserInsDto dto){
        return service.insUser(dto);
    }


}
