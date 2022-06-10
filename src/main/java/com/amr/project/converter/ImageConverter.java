package com.amr.project.converter;

import com.amr.project.model.dto.ImageDto;
import com.amr.project.model.entity.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageConverter {

    ImageDto toDto(Image image);

    Image toImage(ImageDto imageDto);
}
