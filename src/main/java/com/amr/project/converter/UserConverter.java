package com.amr.project.converter;

import com.amr.project.converter.Resolver.UserResolver;
import com.amr.project.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserResolver.class)
public interface UserConverter {
    User toUser(Long userId);
}
