package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.service.InstitutionServiceImpl;

@Controller
public class HomeController {

    private InstitutionServiceImpl institutionService;

    public HomeController(InstitutionServiceImpl institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionService.allInstitutions());
        return "index";
    }
}
