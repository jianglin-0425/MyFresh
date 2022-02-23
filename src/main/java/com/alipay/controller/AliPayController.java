package com.alipay.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description:
 * @author: LIN
 * @create: 2021~06~23 17:40
 */
@RequestMapping("pay")
public class AliPayController {
    public void gotoPay(HttpRequest request, HttpResponse response){
        HttpServletRequest httpquest=(HttpServletRequest) request;
    }
}
