package com.amr.project.converter;

import com.amr.project.model.entity.Chat;
import org.mapstruct.Mapper;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ChatsConverter {
    default Set<Long> mapLongtoList(Set<Chat> chats) {
        if (chats != null) {
            Set<Long> listChatIds = new HashSet<>(chats.size());
            for (Chat chat : chats) {
                listChatIds.add(chat.getId());
            }
            return listChatIds;
        } else {
            return null;
        }
    }
}
