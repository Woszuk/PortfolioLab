package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    private DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public int allBags() {
        List<Donation> donations = donationRepository.findAll();
        int sum =0;
        for(Donation donation: donations){
            sum += donation.getQuantity();
        }

        return sum;
    }
}
