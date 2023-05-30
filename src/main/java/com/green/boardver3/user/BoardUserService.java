package com.green.boardver3.user;

import com.green.boardver3.user.model.BoardUserInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardUserService {
    private  final  BoardUserMapper mapper;

   @Autowired
    public BoardUserService(BoardUserMapper mapper){
        this.mapper= mapper;
    }


    public int insUser(BoardUserInsDto dto){
       return mapper.insUser(dto);
    }


}
