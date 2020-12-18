package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;

@Controller
public class HomeController {

    private InstitutionServiceImpl institutionService;
    private DonationServiceImpl donationService;

    public HomeController(InstitutionServiceImpl institutionService, DonationServiceImpl donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionService.allInstitutions());
        model.addAttribute("quantityOfBags", donationService.allBags());
        model.addAttribute("quantityOfDonations", donationService.allDonation());
        return "index";
    }
}
