package com.amr.project.converter;

import com.amr.project.converter.Resolver.UserResolver;
import com.amr.project.model.dto.MessageDto;
import com.amr.project.model.entity.Message;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = UserResolver.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MessageMapper {

    @Mapping(source = "date", target = "creationTime")
    MessageDto toDTO(Message message);

    Message toModel(MessageDto messageDto);

    List<Message> toModelList(List<MessageDto> messages);

    List<MessageDto> toDTOList(List<Message> messageDtos);

}
