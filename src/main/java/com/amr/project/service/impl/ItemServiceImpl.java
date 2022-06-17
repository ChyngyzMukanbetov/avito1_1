package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ImageDao;
import com.amr.project.dao.abstracts.ItemDao;
import com.amr.project.dao.abstracts.ReviewDao;
import com.amr.project.model.entity.Image;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Review;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl extends ReadWriteServiceImpl<Item, Long> implements ItemService {

    private final ItemDao itemDao;
    private final ReviewDao reviewDao;
    private final ImageDao imageDao;


    @Override
    public List<Item> getItemList() {
        return itemDao.getItemList();
    }


    public ItemServiceImpl(ItemDao itemDao, ImageDao imageDao, ReviewDao reviewDao) {
        super(itemDao);
        this.itemDao = itemDao;
        this.imageDao = imageDao;
        this.reviewDao = reviewDao;
    }


   public Page<Item> getAll (Pageable pageable){
        return itemDao.getAll(pageable);
   }

    @Override
    @Transactional
    public List<Item> getItemsByShopId(Long shopId) {
        List<Item> resultList = itemDao.getItemsByShopId(shopId);
        List<Long> itemIdList = resultList.stream().map(Item::getId).collect(Collectors.toList());
        Map<Long, List<Image>> mapImage = itemIdList.stream()
                .collect(Collectors.toMap(Function.identity(), imageDao::getImagesByItemId));
        Map<Long, List<Review>> mapReview = itemIdList.stream()
                .collect(Collectors.toMap(Function.identity(), reviewDao::getReviewsByItemId));
        resultList.forEach(item -> item.setImages(mapImage.get(item.getId())));
        resultList.forEach(item -> item.setReviews(mapReview.get(item.getId())));
        return resultList;
    }

    public List<Item> getItemsByShop(Shop shop) {
        return itemDao.findAll().stream().filter(item -> item.getShop().equals(shop)).collect(Collectors.toList());
    }
}
