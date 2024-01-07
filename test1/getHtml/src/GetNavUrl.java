import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetNavUrl {
    public Map<String, String> urlMap;
    public String homePage;
    public GetNavUrl(String homePage){
        this.urlMap = new HashMap<>();
        this.homePage = homePage;
    }

    public void getNavUrls() {

        try {
            Document doc = Jsoup.connect(this.homePage).get();

            // Select the <nav> element
            Elements navElements = doc.select("nav");

            // Find all <a> tags within the <nav> element
            Elements links = navElements.select("a[href]");

            // Extract the href attribute from each <a> tag
            for (Element link : links) {
                String linkText = link.text().trim(); // Get the text of the link
                String linkHref = link.attr("abs:href"); // Get the absolute URL
                urlMap.put(linkText, linkHref);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getAllFiles(){
        for(Map.Entry<String, String> entry:urlMap.entrySet()){
            String text = GetHtml.getText(entry.getValue());
            GetHtml.exportTxt(entry.getKey(), text);

        }
    }
}
