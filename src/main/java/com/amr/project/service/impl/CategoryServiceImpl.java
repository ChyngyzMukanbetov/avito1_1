package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.CategoryDao;
import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Category;
import com.amr.project.service.abstracts.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ReadWriteServiceImpl<Category, Long> implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryServiceImpl(ReadWriteDao<Category, Long> dao, CategoryDao categoryDao) {
        super(dao);
        this.categoryDao = categoryDao;
    }


    @Override
    public List<Category> getCategoryList() {
        return categoryDao.getCategoryList();
    }
}
