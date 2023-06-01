package com.green.boardver3.user;

import com.green.boardver3.user.model.BoardUserUpdDto;
import com.green.boardver3.user.model.BoardUserInsDto;
import com.green.boardver3.user.model.BoardUserLoginDto;
import com.green.boardver3.user.model.UserLoginVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardUserMapper {
    int insUser(BoardUserInsDto dto);

    UserLoginVo selUserByUid(BoardUserLoginDto dto);

    int updUser(BoardUserUpdDto dto);
}
