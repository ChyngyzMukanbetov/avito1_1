package com.amr.project.converter;

import com.amr.project.model.dto.ImageDto;
import com.amr.project.model.entity.Image;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ImageMapper {

    ImageDto toDTO(Image image);
    Image toModel(ImageDto imageDto);
    List<Image> toModelList(List<ImageDto> images);
    List<ImageDto> toDTOList(List<Image> imageDto);
}
