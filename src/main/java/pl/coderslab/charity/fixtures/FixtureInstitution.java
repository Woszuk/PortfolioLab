package pl.coderslab.charity.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

@Component
public class FixtureInstitution {
    @Autowired
    private InstitutionRepository institutionRepository;

    public void addInstitutionToDatabases(){
        Institution institution = new Institution()
                .setDescription("Pomoc dzieciom z ubogich rodzin")
                .setName("Dbam o Zdrowie");
        Institution institution2 = new Institution()
                .setDescription("Pomoc wybudzaniu dzieci ze śpiączki")
                .setName("A kogo");
        Institution institution3 = new Institution()
                .setDescription("Pomoc osobom znajdującym się w trudnej sytuacji życiowej")
                .setName("Dla dzieci");
        Institution institution4 = new Institution()
                .setDescription("Pomoc dla osób nie posiadających miejsca zamieszkania")
                .setName("Bez domu");

        institutionRepository.save(institution);
        institutionRepository.save(institution2);
        institutionRepository.save(institution3);
        institutionRepository.save(institution4);
    }
}
