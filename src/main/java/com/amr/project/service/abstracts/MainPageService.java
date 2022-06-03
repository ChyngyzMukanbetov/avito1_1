package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;

import java.util.List;

public interface MainPageService {

    List<Item> listItem();

    List<Shop> listShop();

    List<Category> listCategory();
}
