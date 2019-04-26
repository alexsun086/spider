package main;

import io.FileSource;
import model.Concept;
import model.Stock;
import parse.ConceptParser;
import parse.LeaderStockParser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class THSConception {
    public static void main(String[] args){
            String filePath="E:\\lab\\概念板块";
            Date dNow = new Date();
            SimpleDateFormat dFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            filePath = filePath + "_" + dFormat.format(dNow) + ".csv";

            List<Concept> concepts=ConceptParser.getConcept();
            FileSource.writeConcept(filePath,concepts,"序号,行业,行业指数,涨跌幅,流入资金(亿),流出资金(亿),净额(亿)," +
                    "公司家数,领涨股,涨跌幅,当前价(元)");

            filePath="E:\\lab\\概念股排行";
            List<Stock> stocks=LeaderStockParser.getStock();
            filePath = filePath + "_" + dFormat.format(dNow) + ".csv";
            FileSource.writeStock(filePath,stocks,"概念,序号,代码,名称,现价,涨跌幅,涨跌,换手率,量比," +
                "振幅,成交额,流通股,流通市值,市盈率");

    }
}
