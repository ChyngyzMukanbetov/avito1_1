package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ItemDao;
import com.amr.project.model.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDaoImpl extends ReadWriteDaoImpl<Item, Long> implements ItemDao {

//    Поиск всех товаров в магазине
    @Override
    public List<Item> getItemsByShopId(Long shopId) {
        return em.createQuery(
                        "SELECT NEW com.amr.project.model.entity.Item(" +
                                "i.id, i.name, i.basePrice, i.price, i.count," +
                                "i.rating, i.description, i.discount)" +
                                "FROM Shop s JOIN s.items i WHERE s.id = :shopId", Item.class)
                .setParameter("shopId", shopId).getResultList();
    }

    @Override
    public List<Item> getItemList() {
        return em.createQuery("from item order by rating desc limit 6", Item.class).getResultList();
    }
}
