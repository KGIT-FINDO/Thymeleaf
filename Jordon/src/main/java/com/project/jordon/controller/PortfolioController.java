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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Controller
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @RequestMapping("/portfolio")
    String findo_portfolio(Model listM, PortfolioVO pvo, HttpServletRequest request, HttpServletResponse response, HttpSession session)throws Exception {
        response.setContentType("text/html;Charset=UTF-8");
        String id = (String) session.getAttribute("session");
        PrintWriter out = response.getWriter();

//            System.out.println("login은 가능함.");
        pvo.setMemberid(id);
        List<PortfolioVO> plist = this.portfolioService.getPortfolioList(pvo);//db에서 불러온 보유 포트폴리오 리스트
        List<JSONObject> klist = new ArrayList<>(); //html로 내보낼 json 객체를 담을 리스트.
        for(int i=0; i<plist.size(); i++){
            //
            String num = plist.get(i).getPortfolionumber();//종목코드
            String quantity = plist.get(i).getPortfolioquantity();//보유수량
            String tprice = plist.get(i).getTransactionprice();//매수금액

            //getStock()메서드를 이용해서 detail key값을 가져와서 지정함.
            JSONObject object = StockInfo.getStock(num);
            JSONObject objectdetail = (JSONObject) object.get("detail");

            Long cprice =  (Long)objectdetail.get("currentPrice");//현재 주식가격

            //수익, 수익률, 평단가 계산하는 부분
                //평균단가
                int avgPrice = (Integer.parseInt(quantity)*Integer.parseInt(tprice));


                //수익률 = (현재주식가격 - 구매가격)/구매가격*100
                Long earningsrate;
                earningsrate = (cprice - Integer.parseInt(tprice))/Integer.parseInt(tprice);//*100;

            System.out.println("cprice : "+cprice);
            System.out.println("tprice : "+tprice);
            System.out.println("eprice : "+earningsrate);
            System.out.println("avgP : "+avgPrice);




            //JSON에 db에서 불러온 모유수량과 매수금액, 평균단가 저장
            objectdetail.put("quantity", quantity);
            objectdetail.put("tprice", tprice);
            klist.add(objectdetail);
        }
        listM.addAttribute("plist", plist);
        listM.addAttribute("klist", klist);
        System.out.println("klist : "+klist);
//            //System.out.println("plist : "+plist.get(1).getPortfolionumber());
//            listM.addAttribute("plist",plist);
//            List<String> numlist;
//            String portNum = (String) plist.get(i).


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
