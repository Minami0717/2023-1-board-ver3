package com.green.boardver3.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor //iboard, title, writer, createdAt을 받는 생성자를 만들겠다는 의미
public class BoardVo {
    private int iboard;
    private String title;
    private String createdAt;
    private String writer;
} // setter가 없다 이유는 값을 그대로 데이터베이스에서 받아서 전달해주기때문에 호출만할수 있는 getter만사용한다.
