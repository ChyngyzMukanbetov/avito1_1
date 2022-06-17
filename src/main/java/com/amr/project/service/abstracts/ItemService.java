package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService extends ReadWriteService<Item, Long> {

    List<Item> getItemList();
    List<Item> getItemsByShop(Shop shop);

    Page<Item> getAll (Pageable pageable);

    List<Item> getItemsByShopId(Long shopId);
}
