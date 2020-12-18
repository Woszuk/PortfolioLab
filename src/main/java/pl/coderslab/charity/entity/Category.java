package pl.coderslab.charity.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "categoryList")
    private List<Donation> donations = new ArrayList<>();

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public Category setDonations(List<Donation> donations) {
        this.donations = donations;
        return this;
    }
}
