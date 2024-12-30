package org.iths.bookning.carCategory;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<CarCategory> allCategory() {
        return categoryRepository.findAll();
    }

    public Iterable<CarCategory> getCategoriesByCityId(Long cityId) {
        return categoryRepository.findByCityId(cityId);
    }
}
