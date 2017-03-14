package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@SpringBootApplication
public class MainApplication {

    @RequestMapping(value = "/", name = "Main Application", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    HttpEntity<?> home() {
        Map<String, String> ping = new HashMap<>();

        ping.put("API", "Main API Demo");
        ping.put("buildVersion", "0.0.1");
        ping.put("buildTimestamp", "");

        return new HttpEntity<>(ping);
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
