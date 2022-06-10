package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ImageDao;
import com.amr.project.model.entity.Image;
import com.amr.project.service.abstracts.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl extends ReadWriteServiceImpl<Image, Long> implements ImageService {

    private final ImageDao imageDao;

    public ImageServiceImpl(ImageDao imageDao) {
        super(imageDao);
        this.imageDao = imageDao;
    }


    @Override
    public List<Image> getImagesByItemId(Long itemId) {
        return imageDao.getImagesByItemId(itemId);
    }
}
