package com.example.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
    @RequestMapping("/processFormVersionTwo")
    public String letShouteDude(HttpServletRequest request, Model model){
            String theName = request.getParameter("studentName");

            theName = theName.toUpperCase();
            String result = "Hello, " + theName + "!";
            model.addAttribute("message", result);
            return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){

        theName = theName.toUpperCase();
        String result = "Hello my friend v3 , " + theName;
        model.addAttribute("message", result);
        return "helloworld";
    }
}
