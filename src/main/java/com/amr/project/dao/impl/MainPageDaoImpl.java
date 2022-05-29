package com.amr.project.dao.impl;

import com.amr.project.dao.pages.MainPageDao;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MainPageDaoImpl implements MainPageDao {

    @PersistenceContext
    private final EntityManager entityManager;

    public MainPageDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Item> listItem() {
        List<Item> notSotedList = new ArrayList<>(entityManager.createQuery("From Item", Item.class).getResultList());
        return notSotedList.stream().sorted(((o1, o2) -> (int) (o1.getRating() - o2.getRating()))).collect(Collectors.toList());
    }

    @Override
    public List<Shop> listShop() {
        List<Shop> notSotedList2 = new ArrayList<>(entityManager.createQuery("From Shop", Shop.class).getResultList());
        return notSotedList2.stream().sorted(((o1, o2) -> (int) (o1.getRating() - o2.getRating()))).collect(Collectors.toList());
    }
}
