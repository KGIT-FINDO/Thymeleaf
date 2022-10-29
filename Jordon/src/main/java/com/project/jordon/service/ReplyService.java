package com.project.jordon.service;

import com.project.jordon.vo.ReplyVO;

import java.util.List;

public interface ReplyService {

    void insertReply(ReplyVO vo);
    List<ReplyVO> replyList(int bno);
    void updateReply(ReplyVO vo);
    void delReply(int rno);

}
