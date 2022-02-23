package com.jl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description:
 * @author: LIN
 * @create: 2021~05~19 16:11
 */
@RestController
public class TestController {

    @GetMapping("index")
    public String index(HttpServletRequest request){

        return request.getServletContext().getRealPath("/");
    }
}
