package com.project.jordon.stock;
import com.project.jordon.unixTime.MillToDate;
import org.json.simple.parser.ParseException;

import java.io.IOException;
// can delete whenever you want here
public class StockRealTime {
    public static void main(String[] args) throws ParseException, IOException {
        StockInfo stockInfo = new StockInfo();
        stockInfo.getStock("005930");

        MillToDate millToDate = new MillToDate();
        System.out.println("유닉스:"+millToDate.miltoDate((long)1666851599
        ));


    }

}