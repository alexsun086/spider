package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class THSconception {
    public static void main(String[] args) throws ParseException {
        try {
            //concept rankings
            Document doc = Jsoup.connect("http://data.10jqka.com.cn/funds/hyzjl/").get();
            Elements tables =
                    doc.getElementsByClass("m-table J-ajax-table").select("tbody").select("tr");

            List<String> elementsList = new ArrayList<String>();
            //List<String> conceptUrls = new ArrayList<String>();

            for( Element table:tables){
                Elements lines = table.getElementsByTag("td");
                elementsList.add( lines.first().html()+","
                        +lines.get(1).getElementsByAttribute("target").html()+","
                        +lines.get(2).html()+","
                        +lines.get(3).html()+","
                        +lines.get(4).html()+","
                        +lines.get(5).html()+","
                        +lines.get(6).html()+","
                        +lines.get(7).html()+","
                        +lines.get(8).getElementsByAttribute("target").html()+","
                        +lines.get(9).html()+","
                        +lines.get(10).html());

                //conceptUrls.add(lines.get(1).attr("abs:href"));
            }

            String title="序号,行业,行业指数,涨跌幅,流入资金(亿),流出资金(亿),净额(亿)," +
                    "公司家数,领涨股,涨跌幅,当前价(元)";
            writeFiles(elementsList,"E:\\lab\\","概念板块",title);

        } catch (IOException e) {
            System.out.println("Parse Error！");
            e.printStackTrace();
        }
    }

    public static void writeFiles(List<String> outList,String path,String filename,String title){
        try{
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd_HHmmss");
            filename = path + filename +"_"+ ft.format(dNow)+".csv";

            System.out.println(filename);

            File ZH = new File(filename);
            if (!ZH.isFile()){
                ZH.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(ZH,true);
            BufferedWriter out = new BufferedWriter(fileWriter);

            out.write(title);
            out.newLine();

            for(String value:outList ){
                out.write(value);
                out.newLine();
            }
            out.flush();
            out.close();
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
