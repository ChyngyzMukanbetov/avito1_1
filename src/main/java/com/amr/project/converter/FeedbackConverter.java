package com.amr.project.converter;

import com.amr.project.model.dto.FeedbackDto;
import com.amr.project.model.entity.Feedback;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserConverter.class})
public interface FeedbackConverter {

    @Mapping(source = "user.id", target = "userId")
    FeedbackDto toDto(Feedback feedback);

    Feedback toModel(FeedbackDto feedbackDto);

    List<FeedbackDto> toDtoList(List<Feedback> feedbackList);

    List<Feedback> toModelList(List<FeedbackDto> feedbackDtoList);
}
