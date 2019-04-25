package parse;

import model.Concept;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConceptParser {
    public static List<Concept> getConcept()
    {
        try{
            List<Concept> concepts = new ArrayList<Concept>();

            Document doc = Jsoup.connect("http://data.10jqka.com.cn/funds/hyzjl/").get();
            Elements elements =
                    doc.getElementsByClass("m-table J-ajax-table").select("tbody").select("tr");

            for( Element element:elements){
                Elements lines = element.getElementsByTag("td");

                Concept concept=new Concept();
                concept.setSerial(lines.first().html());
                concept.setConcept(lines.get(1).getElementsByAttribute("target").html());
                concept.setConceptIndex(lines.get(2).html());
                concept.setUpdown(lines.get(3).html());
                concept.setInFund(lines.get(4).html());
                concept.setOutFund(lines.get(5).html());
                concept.setNetFund(lines.get(6).html());
                concept.setCompanyAmount(lines.get(7).html());
                concept.setLeaderStock(lines.get(8).getElementsByAttribute("target").html());
                concept.setLeaderUpdown(lines.get(9).html());
                concept.setLeaderPrice(lines.get(10).html());
                concepts.add(concept);

            }
            return concepts;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
