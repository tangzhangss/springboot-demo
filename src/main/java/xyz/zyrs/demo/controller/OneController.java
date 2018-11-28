package xyz.zyrs.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OneController {

    @RequestMapping("/welcome")
    public String HelloWord(Model model) {

        model.addAttribute("welcome","welcome to use springboot!");

        return "helloword";
    }
}
