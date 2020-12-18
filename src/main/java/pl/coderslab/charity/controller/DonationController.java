package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.service.CategoryServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;

@Controller
public class DonationController {
    private InstitutionServiceImpl institutionService;
    private CategoryServiceImpl categoryService;

    public DonationController(InstitutionServiceImpl institutionService, CategoryServiceImpl categoryService) {
        this.institutionService = institutionService;
        this.categoryService = categoryService;
    }

    @GetMapping("/donation")
    private String donation(Model model) {
        model.addAttribute("categories", categoryService.allCategory());
        model.addAttribute("institutions", institutionService.allInstitutions());
        return "form";
    }
}
