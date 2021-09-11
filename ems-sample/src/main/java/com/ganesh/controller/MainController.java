package com.ganesh.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @created: 11/09/2021 - 12:39 PM
 * @author: Ganesh
 */


@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
