package parse;

import model.Business;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BusinessParser {
    public static List<Business> getBusiness(String link)
    {
        try{
            List<Business> businesses = new ArrayList<Business>();

            Document doc = Jsoup.connect(link).get();
            Elements elements =
                    doc.getElementsByClass("m-table J-ajax-table").select("tbody").select("tr");

            for( Element element:elements){
                Elements lines = element.getElementsByTag("td");

                Business business =new Business();
                business.setSerial(lines.first().html());
                business.setBusiness(lines.get(1).getElementsByAttribute("target").html());
                business.setBusinessIndex(lines.get(2).html());
                business.setUpdown(lines.get(3).html());
                business.setInFund(lines.get(4).html());
                business.setOutFund(lines.get(5).html());
                business.setNetFund(lines.get(6).html());
                business.setCompanyAmount(lines.get(7).html());
                business.setLeaderStock(lines.get(8).getElementsByAttribute("target").html());
                business.setLeaderUpdown(lines.get(9).html());
                business.setLeaderPrice(lines.get(10).html());
                businesses.add(business);

            }
            return businesses;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
