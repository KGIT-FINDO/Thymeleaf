package com.project.jordon.service;

import com.project.jordon.vo.BoardVO;

import java.util.List;

public interface BoardService {

    void insertBoard(BoardVO b);
    int getListCount();
    List<BoardVO> getBoardList(BoardVO b);
    BoardVO getBoardCont(int bno);
    BoardVO getBoardCont2(int bno);
    void updateBoard(BoardVO eb);
    void deleteBoard(int bno);

}
