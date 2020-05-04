package com.filmflix.vodservice.services;

import com.filmflix.vodservice.db.entities.Category;
import com.filmflix.vodservice.db.repositories.CategoryRepository;
import com.filmflix.vodservice.db.repositories.MovieRepository;
import com.filmflix.vodservice.db.repositories.SeriesRepository;
import com.filmflix.vodservice.utilities.CategoryAlreadyExistsException;
import com.filmflix.vodservice.utilities.CategoryNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final SeriesRepository seriesRepository;
    private final MovieRepository movieRepository;

    public Integer addCategory(String name) {
        categoryRepository.findByName(name).ifPresent(category -> {
            throw new CategoryAlreadyExistsException(name);
        });
        return categoryRepository.save(
                Category.builder()
                        .name(name)
                        .visible(true)
                        .build())
                .getId();
    }

    public Integer updateCategory(Integer categoryId, String name) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        category.setName(name);
        return categoryRepository.save(category).getId();
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Integer deleteCategory(Integer categoryId) {
        //validateSeriesWithCategory(categoryId);
        //validateMoviesWithCategory(categoryId);
        categoryRepository.deleteById(categoryId);
        return categoryId;
    }

    /*private void validateSeriesWithCategory(Integer categoryId) {
        seriesRepository.findAll().stream()
                .filter(series -> series.getCategory().getId().equals(categoryId))
                .findAny()
                .ifPresent(series -> {
                    throw new CategoryNotEmptyException();
                });
    }

    private void validateMoviesWithCategory(Integer categoryId) {
        movieRepository.findAll().stream()
                .filter(movie -> movie.getCategory().getId().equals(categoryId))
                .findAny()
                .ifPresent(series -> {
                    throw new CategoryNotEmptyException();
                });
    }*/
}
