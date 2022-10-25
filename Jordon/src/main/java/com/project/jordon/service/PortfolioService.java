package com.project.jordon.service;

import com.project.jordon.vo.PortfolioVO;

import java.util.List;

public interface PortfolioService {
    List<PortfolioVO> getPortfolioList(PortfolioVO pvo);
}
