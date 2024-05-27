package com.agudelo.configserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.agudelo.configserver.entity.Config;

@RestController
public class ConfigController {
	@Autowired
    Config config;

    @GetMapping("/endpoint")
    public String retrieveLimits(){
        return config.getValue();
    }


}
