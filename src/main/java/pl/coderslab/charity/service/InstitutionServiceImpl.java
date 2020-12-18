package pl.coderslab.charity.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    private InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> allInstitutions() {
        return institutionRepository.findAll();
    }
}
