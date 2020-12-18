package pl.coderslab.charity.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "institution")
    private List<Donation> donationList = new ArrayList<>();

    public Institution() {
    }

    public Long getId() {
        return id;
    }

    public Institution setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Institution setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Institution setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Donation> getDonationList() {
        return donationList;
    }

    public Institution setDonationList(List<Donation> donationList) {
        this.donationList = donationList;
        return this;
    }
}
