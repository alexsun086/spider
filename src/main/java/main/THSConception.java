package main;

import io.FileSource;
import model.Business;
import model.Stock;
import parse.BusinessParser;
import parse.BusinessStockParser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class THSConception {
    public static void main(String[] args){
            Date dNow = new Date();
            SimpleDateFormat dFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            //行业板块排行
            String fileBusiness="E:\\lab\\行业板块";
            fileBusiness = fileBusiness + "_" + dFormat.format(dNow) + ".csv";
            List<Business> businesses = BusinessParser.getBusiness("http://data.10jqka.com.cn/funds/hyzjl/");
            FileSource.writeBusiness(fileBusiness, businesses,"序号,行业,行业指数,涨跌幅,流入资金(亿),流出资金(亿),净额(亿)," +
                    "公司家数,领涨股,涨跌幅,当前价(元)");
            //概念板块排行
            String fileBusiness2="E:\\lab\\概念板块";
            fileBusiness2 = fileBusiness2 + "_" + dFormat.format(dNow) + ".csv";
            List<Business> businesses2 = BusinessParser.getBusiness("http://data.10jqka.com.cn/funds/gnzjl/");
            FileSource.writeBusiness(fileBusiness2, businesses2,"序号,行业,行业指数,涨跌幅,流入资金(亿),流出资金(亿),净额(亿)," +
                    "公司家数,领涨股,涨跌幅,当前价(元)");

            //行业股排行
            String fileBusinessStock="E:\\lab\\行业股排行";
            fileBusinessStock = fileBusinessStock + "_" + dFormat.format(dNow) + ".csv";

            List<Stock> stocks= BusinessStockParser.getStock("http://q.10jqka.com.cn/thshy/detail/code/881163/");
            FileSource.writeStock(fileBusinessStock,stocks,"概念,序号,代码,名称,现价,涨跌幅,涨跌,换手率,量比," +
                    "振幅,成交额,流通股,流通市值,市盈率");

            //概念股排行
            String fileBusinessStock2="E:\\lab\\概念股排行";
            fileBusinessStock2 = fileBusinessStock2 + "_" + dFormat.format(dNow) + ".csv";
            List<Stock> stocks2= BusinessStockParser.getStock("http://q.10jqka.com.cn/gn/detail/code/300419/");
            FileSource.writeStock(fileBusinessStock2,stocks2,"概念,序号,代码,名称,现价,涨跌幅,涨跌,换手率,量比," +
                    "振幅,成交额,流通股,流通市值,市盈率");

    }
}
