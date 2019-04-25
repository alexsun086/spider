package main;

import io.FileSource;
import model.Concept;
import parse.ConceptParser;

import java.io.IOException;
import java.text.ParseException;
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
            FileSource.writeContent(filePath,concepts,"序号,行业,行业指数,涨跌幅,流入资金(亿),流出资金(亿),净额(亿)," +
                    "公司家数,领涨股,涨跌幅,当前价(元)");

    }
}
