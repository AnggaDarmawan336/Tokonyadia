package com.example.tokonyadia.controller;

import com.example.tokonyadia.entity.Customer;
import com.example.tokonyadia.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class HTMLController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<html><body><h1>Hello World!</h1><h2>Hello World!</h2><h2>Hello World!</h2></body></html>";
    }

}
