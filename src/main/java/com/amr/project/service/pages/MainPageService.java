package com.amr.project.service.pages;

import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;

import java.util.List;

public interface MainPageService {

    List<Item> listItem();

    List<Shop> listShop();
}
