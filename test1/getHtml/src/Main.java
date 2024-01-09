//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        GetNavUrl getNavUrl =  new GetNavUrl("https://docs.osmosis.zone/osmosis-core/");
        //更换这里的链接即可,要求是homepage
        getNavUrl.getNavUrls();
        getNavUrl.getAllFiles();
        getNavUrl.getWholeText();
    }
}