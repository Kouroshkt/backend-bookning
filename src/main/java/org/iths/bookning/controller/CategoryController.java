package org.iths.bookning.controller;

import org.iths.bookning.entities.CarCategory;
import org.iths.bookning.services.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/getall")
    public Iterable<CarCategory> allCategory() {
        return categoryService.allCategory();
    }
    @GetMapping("/getcategory/{city_id}")
    public Iterable<CarCategory> getCategoryByCityId(@PathVariable Long city_id) {
        return categoryService.getCategoriesByCityId(city_id);
    }
}
