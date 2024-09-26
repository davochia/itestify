package com.dattech.iTestify.controller;

import com.dattech.iTestify.dto.WikiCategoryDto;
import com.dattech.iTestify.exception.CategoryNotFoundException;
import com.dattech.iTestify.service.ItestifyImpl.ItestifyServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private ItestifyServiceImpl itestifyServiceImpl;

    // Add new Category
    @ApiOperation(value="Add a new category to system", response= WikiCategoryDto.class)
    @PostMapping("/category")
    public WikiCategoryDto addCategory(@RequestBody WikiCategoryDto wikiCategoryDto) {
        return itestifyServiceImpl.addWikiCategory(wikiCategoryDto);
    }

    // Get Wiki Categories
    @ApiOperation(value="Get all categories from system", response= WikiCategoryDto.class)
    @GetMapping("/categories")
    public List<WikiCategoryDto> getCategories()  {
        return itestifyServiceImpl.getWikiCategories();

    }


    // Get wiki category by id
    @ApiOperation(value="Get wiki category from system find by id", response= WikiCategoryDto.class)
    @GetMapping("/category/{id}")
    public WikiCategoryDto getCategory(@PathVariable Integer id) throws CategoryNotFoundException {
        return itestifyServiceImpl.findWikiCategoryById(id);

    }


    // Edit Category
    @ApiOperation(value="Edit category in the system", response= WikiCategoryDto.class)
    @PutMapping("/category/{id}")
    public WikiCategoryDto editCategory(@PathVariable Integer id, @RequestBody WikiCategoryDto wikiCategoryDto){
        return itestifyServiceImpl.modifyWikiCategory(id, wikiCategoryDto);
    }

    // Delete category
    @ApiOperation(value="Delete category from system", response= WikiCategoryDto.class)
    @DeleteMapping("/category/{id}")
    public Boolean deleteCategory(@PathVariable Integer id) {
        return itestifyServiceImpl.removeWikiCategory(id);
    }
}
