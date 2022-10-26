package com.project.jordon.service;

import com.project.jordon.dao.PortfolioDAO;
import com.project.jordon.vo.PortfolioVO;
import com.project.jordon.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService{
    @Autowired
    PortfolioDAO portfolioDAO;
    @Override
    public List<PortfolioVO> getPortfolioList(PortfolioVO pvo) {
        return this.portfolioDAO.getPortfolioList(pvo);
    }

    @Override
    public List<SearchVO> getSearchList(SearchVO svo) {
        return this.portfolioDAO.getSearchList(svo);
    }
}