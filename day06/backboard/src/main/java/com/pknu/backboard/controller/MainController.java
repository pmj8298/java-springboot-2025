package com.pknu.backboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;


@Controller
@Log4j2
public class MainController {
    @GetMapping("/start") // RESTful URL로 웹사이트 요청
    public String start() {
        log.info("/start 실행!"); // 로그출력
        return "start"; // resources/templates/start.html 
    }
    

}
