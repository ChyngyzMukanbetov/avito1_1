package com.amr.project.dao.abstracts;

import com.amr.project.model.entity.Image;

import java.util.List;

public interface ImageDao extends ReadWriteDao<Image, Long> {

    List<Image> getImagesByItemId(Long itemId);
}
