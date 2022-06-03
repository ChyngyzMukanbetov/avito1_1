package com.amr.project.dao.abstracts;

import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainPageDao {

    List<Item> listItem();

    List<Shop> listShop();

    List<Category> listCategory();
}
