package com.green.boardver3.user;

import com.green.boardver3.user.model.BoardUserInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardUserMapper {
         int insUser(BoardUserInsDto dto);

}
