package com.project.jordon.dao;

import com.project.jordon.vo.PortfolioVO;

import java.util.List;

public interface PortfolioDAO {
    List<PortfolioVO> getPortfolioList(PortfolioVO pvo);
}
