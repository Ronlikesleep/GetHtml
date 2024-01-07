import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;

public class GetHtml {

    public GetHtml(){
    }
    public static String getText(String url){
        try {
            Document doc = Jsoup.connect(url).get();
            doc.select("nav").remove();
            doc.select("header").remove();
            String text = doc.text(); // Extracts all text from the HTML
            System.out.println("Successfully get html!");
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void exportTxt(String fileName,String text){

        String filePath = "/Users/zhangshanrong/Desktop/test1/output/"+fileName+".txt";
        //改成本地地址
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(text);
            System.out.println("Text successfully written to" +fileName+"file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }
}
