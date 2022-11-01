package com.project.jordon.vo;

import lombok.Data;

@Data
public class NewsVO {
    private int nno;
    private String nwriter;
    private String ntitle;
    private String ncontent;
    private int nviewcnt; // 조회수
    private String nregdate;

    private int startrow; // 시작번호
    private int endrow; // 끝번호
}
