package com.amr.project.dao.impl;

import com.amr.project.converter.ShopMapper;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Shop;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShopReadWriteDaoImpl extends ReadWriteDaoImpl<Shop, Long> {
    private ShopMapper shopMapper;
    public List<ShopDto> findByPartName(String name) {
        List<ShopDto> result = new ArrayList<>();

        List<Shop> shopList = em.createQuery("select s from Shop s where s.name like :name")
                .setParameter("name", name)
                .getResultList();

        for (Shop s : shopList) {
            result.add(shopMapper.toDTO(s));
        }
        return result;
    }
}