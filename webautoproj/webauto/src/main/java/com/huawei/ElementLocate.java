package com.huawei;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ElementLocate {
    private static ChromeDriver chromeDriver;
    private static Map<String, String> urlMap;

    public ElementLocate() {
        urlMap = new HashMap<>();
    }

    public static void openChrome() {
        System.setProperty("webdriver.chrome.driver", "webauto/src/main/resources/chromedriver");
        chromeDriver = new ChromeDriver();
    }

    public void autoClick(String targetUrl) {
        openChrome();
        chromeDriver.navigate().to(targetUrl);
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String targetTagName = "nav";
        WebElement navElement = chromeDriver.findElement(By.tagName(targetTagName));
        List<WebElement> list = navElement.findElements(By.tagName("a"));
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);
        for (int i = 0; i < list.size(); i++) {
            try {
                navElement = chromeDriver.findElement(By.tagName(targetTagName));
                list = navElement.findElements(By.tagName("a"));
                WebElement wb = list.get(i);
                String currUrl = wb.getAttribute("href");
                if (!currUrl.substring(0, 12).equals(targetUrl.substring(0, 12)))
                    continue;

                // Wait for the element to be clickable
                wait.until(ExpectedConditions.elementToBeClickable(wb));

                // Scroll the element into view
                ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", wb);
                Thread.sleep(500); // Brief pause after scrolling

                System.out.println(wb.getText() + " is clicked. ");

                // Click the element
                wb.click();
                urlMap.put(wb.getText(), currUrl);
            } catch (Exception e) {
                System.out.println("Failed to click on element. Error: " + e.getMessage());
                try {
                    ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].click();", list.get(i));
                } catch (Exception jsClickException) {
                    System.out.println("JavaScript click also failed. Error: " + jsClickException.getMessage());
                }
            }
        }
    }

    public Map<String, String> getMap() {
        return urlMap;
    }
}
