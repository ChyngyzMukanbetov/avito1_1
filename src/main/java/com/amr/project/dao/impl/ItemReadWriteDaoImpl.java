package com.amr.project.dao.impl;

import com.amr.project.converter.ItemMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemReadWriteDaoImpl extends ReadWriteDaoImpl<Item, Long> {
    private ItemMapper itemMapper;
    public List<ItemDto> findByPartNameItem (String name) {
        List<ItemDto> result = new ArrayList<>();
        List<Item> itemList = em.createQuery("select i from Item i where i.name like :name")
                .setParameter("name", name)
                .getResultList();

        for(Item i: itemList) {
           result.add(itemMapper.toDTO(i));
        }
        return result;
    }

}
