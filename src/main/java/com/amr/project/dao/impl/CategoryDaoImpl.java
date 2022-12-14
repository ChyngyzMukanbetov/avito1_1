package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.CategoryDao;
import com.amr.project.model.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl extends ReadWriteDaoImpl<Category, Long> implements CategoryDao {

    @Override
    public List<Category> getCategoryList() {
        return  em.createQuery("select u from Category u order by u.name", Category.class).getResultList();
    }
}
