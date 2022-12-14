package com.amr.project.converter.Resolver;

import com.amr.project.model.dto.UserDto;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserResolver {

    private final UserService userService;

    @ObjectFactory
    public User resolve(Long userId, @TargetType Class<User> type) {
        if (userId == null) {
            return null;
        } else {
            return userService.findById(userId);
        }
    }

    @ObjectFactory
    public User resolve(UserDto userDto, @TargetType Class<User> type) {
        if (userDto == null) {
            return null;
        } else if (userDto.getId() == null) {
            return new User();
        } else {
            return userService.findById(userDto.getId());
        }
    }
}
