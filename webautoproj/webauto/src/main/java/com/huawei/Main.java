package com.huawei;

import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void clearFolder(File folder) {
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        clearFolder(file);
                    }
                    file.delete();
                }
            }
        }
    }


    public static void main(String[] args) {
        File folder = new File("webauto/output");
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        clearFolder(file);
                    }
                    file.delete();
                }
            }
        }

        String targetUrl = "https://docs.aboard.exchange/";
        ElementLocate elementLocate = new ElementLocate();
        elementLocate.autoClick(targetUrl);
        Map<String, String> map = elementLocate.getMap();
        GenerateTxt generateTxt = new GenerateTxt(map);
        generateTxt.getAllFiles();
        
        Pattern pattern = Pattern.compile("https?://([^/]+)/");
        Matcher matcher = pattern.matcher(targetUrl);

        if (matcher.find()) { 
            String extracted = matcher.group(1); 
            String replaced = extracted.replace(".", "_");
            System.out.println(replaced);
            String targetName = "Project "+replaced;
            generateTxt.getWholeText(targetName);
        } else {
            generateTxt.getWholeText("Project "+targetUrl);
        }

    }
}