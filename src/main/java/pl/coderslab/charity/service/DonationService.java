package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Donation;

public interface DonationService {
    int allBags();
    int allDonation();
    void save(Donation donation);
}
