package com.blgncan.enterprise.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("api/hello")
   public  String helle(){
    return "Hello Enterprise Platform!";
   }

}
