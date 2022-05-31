package com.amr.project.dao.impl;

import com.amr.project.dao.pages.MainPageDao;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class MainPageDaoImpl implements MainPageDao {

    @PersistenceContext
    private final EntityManager entityManager;

    public MainPageDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Item> listItem() {
        return entityManager.createQuery("from item order by rating desc ", Item.class).getResultList();
    }

    @Override
    public List<Shop> listShop() {
        return entityManager.createQuery("from shop order by rating desc ", Shop.class).getResultList();
    }
}
