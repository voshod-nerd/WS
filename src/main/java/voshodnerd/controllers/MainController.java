package voshodnerd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @GetMapping("/main")
    public String printHello(ModelMap model) {
        //model.addAttribute("message", "Hello Spring MVC Framework!");
        System.out.println("Main");
        return "main";
    }

}
