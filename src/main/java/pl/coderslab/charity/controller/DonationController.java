package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.service.CategoryServiceImpl;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;

import javax.validation.Valid;

@Controller
public class DonationController {
    private InstitutionServiceImpl institutionService;
    private CategoryServiceImpl categoryService;
    private DonationServiceImpl donationService;

    public DonationController(InstitutionServiceImpl institutionService, CategoryServiceImpl categoryService, DonationServiceImpl donationService) {
        this.institutionService = institutionService;
        this.categoryService = categoryService;
        this.donationService = donationService;
    }

    @GetMapping("/form")
    private String donation(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryService.allCategory());
        model.addAttribute("institutions", institutionService.allInstitutions());
        return "form";
    }

    @PostMapping("/form")
    private String donationForm(@ModelAttribute("donation") @Valid Donation donation, BindingResult result){
        if(result.hasErrors()){
            return "form";
        }
        donationService.save(donation);
        return "form-confirmation";
    }
}
