package com.dattech.iTestify.controller;


import com.dattech.iTestify.service.HelloImpl.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private Hello helloService;

//    @ApiOperation(value="Add a new author to system", response= Author.class)
    @GetMapping("/hello")
    public String helloWorld(){
        return helloService.getHello();
    }

    @PostMapping("/name")
    public String postName(@RequestBody String name){
        return helloService.putHello(name);
    }
}
