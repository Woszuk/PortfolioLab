package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private UserServiceImpl userService;

    public RegistrationController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") @Valid User user, BindingResult result, Model model, @RequestParam("password2") String password2){
        if(result.hasErrors() || !user.getPassword().equals(password2)){
            if(user.getPassword().length() >=8){
                model.addAttribute("error", "error");
            }
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/";
    }
}
