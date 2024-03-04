package com.huawei;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;

public class GetHtml {
    public GetHtml() {
    }

    public static String getText(String url) {
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

    public static void exportTxt(String fileName, String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : fileName.toCharArray()) {
            if ((int) (c - 'a') >= 0 && (int) (c - 'z') <= 0 || (int) (c - 'A') >= 0 && (int) (c - 'Z') <= 0
                    || (int) (c - '0') >= 0 && (int) (c - '9') <= 0) {
                sb.append(c);
            }
        }
        fileName = sb.toString();
        String filePath = "webauto/output/" + fileName + ".txt";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(text);
            System.out.println("Text successfully written to" + fileName + "file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }
}
