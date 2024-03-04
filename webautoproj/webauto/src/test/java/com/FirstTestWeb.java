package com;

import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestWeb {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webauto/src/main/resources/chromedriver");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.com");

    }
}
