package com.gilxyj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: activemq02
 * @description:
 * @author: GilbertXiao
 * @create: 2019-07-14 19:47
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
