package com.project.jordon.controller;

import com.project.jordon.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsController {
    @Autowired
    NewsService newsService;

    @RequestMapping("/news")
    public String findo_news() {
        return "findo_news";
    }

}
