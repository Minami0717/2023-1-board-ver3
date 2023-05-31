package com.green.boardver3.cmt.model;

import lombok.Data;

@Data
public class BoardCmtEntity {
    private int iboardCmt; // 여기에 새로 생성된 pk값을 담아주고 이걸 다시 프론트엔드로 던져주기위해 여기담은걸 entity로 호출해서 던짐
    private int iboard;
    private int iuser;
    private String ctnt;
    private String createdAt;
    private String updatedAt;
}
