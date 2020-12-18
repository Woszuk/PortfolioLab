package pl.coderslab.charity.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.repository.InstitutionRepository;

@Component
public class Fixture {
    private FixtureInstitution fixtureInstitution;
    private FixtureCategory fixtureCategory;

    public Fixture(FixtureInstitution fixtureInstitution, FixtureCategory fixtureCategory) {
        this.fixtureInstitution = fixtureInstitution;
        this.fixtureCategory = fixtureCategory;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void databases(){
        fixtureInstitution.addInstitutionToDatabases();
        fixtureCategory.addCategoryToDatabases();
    }
}
