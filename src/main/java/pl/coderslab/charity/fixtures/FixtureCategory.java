package pl.coderslab.charity.fixtures;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.repository.CategoryRepository;

@Component
public class FixtureCategory {
    private CategoryRepository categoryRepository;

    public FixtureCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategoryToDatabases(){
        Category category = new Category()
                .setName("ubrania, które nadają się do ponownego użytku");
        Category category2 = new Category()
                .setName("ubrania do wyrzucenia");
        Category category3 = new Category()
                .setName("zabawki");
        Category category4 = new Category()
                .setName("książki");
        Category category5 = new Category()
                .setName("inne");

        categoryRepository.save(category);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);
        categoryRepository.save(category5);
    }
}
