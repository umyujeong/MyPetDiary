package com.mpd.mypetdiary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testcontroller {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
