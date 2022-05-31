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
        List<Item> notSortedList = new ArrayList<>(entityManager.createQuery("From Item", Item.class).getResultList());
        return notSortedList.stream().sorted(((o1, o2) -> (int) (o2.getRating() - o1.getRating()))).collect(Collectors.toList());
    }

    @Override
    public List<Shop> listShop() {
        List<Shop> notSortedList2 = new ArrayList<>(entityManager.createQuery("From Shop", Shop.class).getResultList());
        return notSortedList2.stream().sorted(((o1, o2) -> (int) (o2.getRating() - o1.getRating()))).collect(Collectors.toList());
    }
}
