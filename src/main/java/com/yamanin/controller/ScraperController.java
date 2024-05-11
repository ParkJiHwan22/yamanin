package com.yamanin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.yamanin.WebScraper;

@RestController
@RequestMapping("")
public class ScraperController {

    private final WebScraper webScraper;

    @Autowired
    public ScraperController(WebScraper webScraper) {
        this.webScraper = webScraper;
    }

    @GetMapping("/scrape")
    public String scrape() {
        return webScraper.scrape();
    }
}
