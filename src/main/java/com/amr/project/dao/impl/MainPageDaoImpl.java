package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.MainPageDao;
import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class MainPageDaoImpl implements MainPageDao {

    @PersistenceContext
    private final EntityManager em;

    public MainPageDaoImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public List<Item> listItem() {
        return em.createQuery("from item order by rating desc limit 6", Item.class).getResultList();
    }

    @Override
    public List<Shop> listShop() {
        return em.createQuery("from shop order by rating desc limit 4", Shop.class).getResultList();
    }

    @Override
    public List<Category> listCategory() {
        return em.createQuery("from category", Category.class).getResultList();
    }
}
