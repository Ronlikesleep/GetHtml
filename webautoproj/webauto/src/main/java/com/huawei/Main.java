package com.huawei;

import java.io.File;
import java.util.Map;

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
        File folder = new File("output");
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

        String targetUrl = "https://docs.kinza.finance/introduction/welcome-to-kinza";
        ElementLocate elementLocate = new ElementLocate();
        elementLocate.autoClick(targetUrl);
        Map<String, String> map = elementLocate.getMap();
        GenerateTxt generateTxt = new GenerateTxt(map);
        generateTxt.getAllFiles();
        generateTxt.getWholeText();

    }
}