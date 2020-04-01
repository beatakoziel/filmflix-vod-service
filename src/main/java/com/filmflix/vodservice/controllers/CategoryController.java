package com.filmflix.vodservice.controllers;


import com.filmflix.vodservice.db.entities.Category;
import com.filmflix.vodservice.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Void> addCategory(String name) {
        categoryService.addCategory(name);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Integer> addCategory(@PathVariable Integer categoryId, String name) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryId, name));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Integer> deleteCategory(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }
}
