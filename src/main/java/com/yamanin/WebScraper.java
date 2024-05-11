package com.yamanin;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WebScraper {

    public String scrape() {
        String url = "https://statiz.sporki.com/schedule/?year=2024&month=5";
        try {
            Document doc = Jsoup.connect(url).get();
            String selectorStr = "body > div.warp > div.container > section > div.box_type_boared > div > div > div > div.box_cont > div > table > tbody > tr:nth-child(1) > td:nth-child(6) span ";
            Elements elements = doc.select(selectorStr);
            return elements.html();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error during web scraping: " + e.getMessage();
        }
    }
}