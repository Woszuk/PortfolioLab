package pl.coderslab.charity.fixtures;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.repository.RoleRepository;

@Component
public class FixtureRole {

    private RoleRepository roleRepository;

    public FixtureRole(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole(){
        Role role = new Role().setName("ROLE_USER");
        Role role2 = new Role().setName("ROLE_ADMIN");

        roleRepository.save(role);
        roleRepository.save(role2);
    }
}
