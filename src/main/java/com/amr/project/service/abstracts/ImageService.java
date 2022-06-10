package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Image;

import java.util.List;

public interface ImageService extends ReadWriteService<Image, Long> {

    List<Image> getImagesByItemId(Long itemId);
}
