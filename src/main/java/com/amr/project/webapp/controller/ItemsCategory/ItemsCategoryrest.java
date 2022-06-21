package com.amr.project.webapp.controller.ItemsCategory;
import com.amr.project.converter.CategoryMapper;
import com.amr.project.model.dto.CategoryDto;
import com.amr.project.model.entity.Category;
import com.amr.project.service.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemsCategoryrest {

    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    @Autowired
    public ItemsCategoryrest(CategoryMapper categoryMapper, CategoryService categoryService) {
        this.categoryMapper = categoryMapper;
        this.categoryService = categoryService;
    }

    @GetMapping("/categoryItems")
    public ResponseEntity<List<CategoryDto>> getAllItemsCategory(){
        List<Category> categoryList = categoryService.findAll();
        return categoryList!=null
                ?new ResponseEntity<>(categoryMapper.toDTOList(categoryList), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

