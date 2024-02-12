package inhatc.cse.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(Model model) {

        model.addAttribute("data", "스프링 프레임워크 Spring Framework!");
        return "home";
    }

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
}