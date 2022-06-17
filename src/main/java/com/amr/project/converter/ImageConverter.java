package com.amr.project.converter;

import com.amr.project.model.dto.ImageDto;
import com.amr.project.model.entity.Image;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageConverter {

    ImageDto toDto(Image image);

    Image toImage(ImageDto imageDto);

    default ImageDto mapListToDto(List<Image> images) {
        if (images != null && images.size() > 0) {
            return toDto(images.get(0));
        } else {
            return null;
        }
    }
}
