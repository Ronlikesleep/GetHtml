package com.huawei;
import java.util.Map;

public class GenerateTxt {
    private Map<String, String> urlMap;
    public GenerateTxt(Map<String, String> map){
        this.urlMap = map;
    }

    public void getAllFiles(){
        for(Map.Entry<String, String> entry:urlMap.entrySet()){
            String text = GetHtml.getText(entry.getValue());
            GetHtml.exportTxt(entry.getKey(), text);
        }
    }

    public void getWholeText(){
        String res = " ";
        for(Map.Entry<String, String> entry:urlMap.entrySet()){
            String text = GetHtml.getText(entry.getValue());
            res+=text;
            res += "\n\n\n";
        }
        GetHtml.exportTxt("WholeText", res);
    }

}
