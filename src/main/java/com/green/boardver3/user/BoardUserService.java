package com.green.boardver3.user;

import com.green.boardver3.user.model.BoardUserUpdDto;
import com.green.boardver3.user.model.BoardUserInsDto;
import com.green.boardver3.user.model.BoardUserLoginDto;
import com.green.boardver3.user.model.UserLoginVo;
import com.green.boardver3.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardUserService {
    private final BoardUserMapper mapper;
    private final CommonUtils commonUtils;

   @Autowired
    public BoardUserService(BoardUserMapper mapper, CommonUtils commonUtils){
       this.mapper= mapper;
       this.commonUtils = commonUtils;
   }


    public int insUser(BoardUserInsDto dto){
        //성별 항상 대문자 변경
        char gender = Character.toUpperCase(dto.getGender());
        if (!(gender == 'M' || gender == 'F')) {
            return -1;
        }
        dto.setGender(gender);

        //비밀번호 암호화
//        String upw = dto.getUpw();
//        String changeUpw = commonUtils.encodeSha256(upw);
//        dto.setUpw(changeUpw);

        dto.setUpw(commonUtils.encodeSha256(dto.getUpw()));
        try {
            return mapper.insUser(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int login(BoardUserLoginDto dto){
        UserLoginVo vo = mapper.selUserByUid(dto);//객체화해줬으니까 null
         if(vo==null){
             return 2;
         }else if(vo.getUpw().equals(commonUtils.encodeSha256(dto.getUpw()))){
             return 1;
        }   return 3;
    }

    public int updUser(BoardUserUpdDto dto){
        dto.setUpw(commonUtils.encodeSha256(dto.getUpw()));
        return mapper.updUser(dto);
    }
}
