package com.project.jordon.dao;

import com.project.jordon.vo.PortfolioVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PortfolioDAOImpl implements PortfolioDAO{
    @Autowired
    SqlSession sqlSession;
    @Override
    public List<PortfolioVO> getPortfolioList(PortfolioVO pvo) {
        return sqlSession.selectList("portfolioList",pvo);
    }
}
