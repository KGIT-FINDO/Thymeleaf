package com.project.jordon.controller;

import com.project.jordon.service.PortfolioService;
import com.project.jordon.stock.StockInfo;
import com.project.jordon.vo.PortfolioVO;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @RequestMapping("/portfolio")
    String findo_portfolio(Model listM, PortfolioVO pvo, HttpServletRequest request, HttpServletResponse response, HttpSession session)throws Exception {
        response.setContentType("text/html;Charset=UTF-8");
        String id = (String) session.getAttribute("session");
        PrintWriter out = response.getWriter();

            System.out.println("login은 가능함.");
            pvo.setMemberid(id);
            List<PortfolioVO> plist = this.portfolioService.getPortfolioList(pvo);
            System.out.println(pvo);
            listM.addAttribute("plist",plist);

        return "findo_portfolio";
    }

    @GetMapping("port_cont")
    public ModelAndView getCont(@RequestParam("portfolionumber") String portfolionumber, HttpServletResponse response) throws ParseException, IOException {
        response.setContentType("text/html;Charset=UTF-8");
        StockInfo stockInfo = new StockInfo();
        JSONObject stock = stockInfo.getStock(portfolionumber);
        ModelAndView cm = new ModelAndView();
        cm.addObject("stock", stock);
        System.out.println(stock.get("detail"));

        cm.setViewName("port_cont");

        return cm;
    }
}
