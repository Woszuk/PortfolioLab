package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    private String login(Model model, @RequestParam(required = false) String error){
        if(error != null){
            model.addAttribute("error", "error");
        }
        return "login";
    }
}
