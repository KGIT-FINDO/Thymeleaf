package com.project.jordon.dao;

import com.project.jordon.vo.ReplyVO;

import java.util.List;

public interface ReplyDAO {

    void insertReply(ReplyVO vo);
    List<ReplyVO> replyList(int bno);
    void updateReply(ReplyVO vo);
    void delReply(int rno);
    int getBno(int rno);

}
