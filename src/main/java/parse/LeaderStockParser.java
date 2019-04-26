package parse;

import model.Stock;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class LeaderStockParser {
    public static List<Stock> getStock()
    {
        try{

             List<Stock> stocks=new ArrayList<Stock>();

             HashMap<String,String> urlMap=new HashMap<String,String>();

             Document conceptDoc=
                    Jsoup.connect("http://q.10jqka.com.cn/thshy/detail/code/881163/").get();
             Elements conceptElements =
                    conceptDoc.getElementsByClass("category boxShadow m_links").select("a");
             for(Element conceptElement:conceptElements){
                 urlMap.put(conceptElement.html(),
                        conceptElement.select("a").attr("href"));
                //System.out.println("conceptKey：" +conceptElement.html());
                //System.out.println("conceptHref："+conceptElement.select("a").attr("href"));
            }


             for(Map.Entry<String, String> entry : urlMap.entrySet()){//url loop
                String concept=entry.getKey();
                //System.out.println("concept:"+ concept);

                String url=entry.getValue();

                Document stockDoc = Jsoup.connect(url).get();
                Elements stockElements =
                        stockDoc.getElementsByClass("m-table m-pager-table").select("tbody").select("tr");
                for(Element stockElement:stockElements){
                    Stock stock=new Stock();
                    Elements lines = stockElement.getElementsByTag("td");
                    stock.setSerial(lines.first().html());
                    stock.setCode(lines.get(1).getElementsByAttribute("target").html());
                    stock.setName(lines.get(2).getElementsByAttribute("target").html());
                    stock.setPrice(lines.get(3).html());
                    stock.setUpdown(lines.get(4).html());
                    stock.setUpdownPrice(lines.get(5).html());
                    stock.setTurnover(lines.get(6).html());
                    stock.setVolRatio(lines.get(7).html());
                    stock.setAmplitude(lines.get(8).html());
                    stock.setVol(lines.get(9).html());
                    stock.setTradeable(lines.get(10).html());
                    stock.setMarketValue(lines.get(11).html());
                    stock.setPE(lines.get(12).html());
                    stock.setConcept(concept);
                    stocks.add(stock);
                }//element loop
            }//url loop

            return stocks;
         }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
