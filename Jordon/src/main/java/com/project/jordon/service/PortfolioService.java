package com.project.jordon.service;

import com.project.jordon.vo.PortfolioVO;
import com.project.jordon.vo.SearchVO;

import java.util.List;

public interface PortfolioService {
    List<PortfolioVO> getPortfolioList(PortfolioVO pvo);

    List<SearchVO> getSearchList(SearchVO svo);
}
