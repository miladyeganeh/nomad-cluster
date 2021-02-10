package com.nomadsample.controller;


import com.nomadsample.model.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

    @GetMapping("/")
    public String getUser(HttpServletRequest request) {
        Data data = new Data(request.getRemoteAddr(), String.valueOf(request.getRemotePort()), request.getServerName(),
                String.valueOf(request.getServerPort()), request.getRemoteHost(),
                request.getLocalAddr(), String.valueOf(request.getLocalPort()), "6.6.0-SNAPSHOT"
        );
        return data.toString();
    }
}

