package pl.coderslab.charity.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.repository.InstitutionRepository;

@Component
public class Fixture {
    @Autowired
    private FixtureInstitution fixtureInstitution;
    private InstitutionRepository institutionRepository;

    public Fixture(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void databases(){
        fixtureInstitution.addInstitutionToDatabases(institutionRepository);
    }
}
