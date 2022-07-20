package com.dattech.iTestify.service.HelloImpl;

import com.dattech.iTestify.service.HelloI;
import org.springframework.stereotype.Service;

@Service
public class Hello implements HelloI {
    @Override
    public String getHello() {
        return "Hello world Stella";
    }

    @Override
    public String putHello(String name) {

        return "Hello world " + name;
    }
}
