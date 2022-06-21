package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Chat;
import com.amr.project.service.abstracts.ChatService;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl extends ReadWriteServiceImpl<Chat, Long> implements ChatService {
    public ChatServiceImpl(ReadWriteDao<Chat, Long> dao) {
        super(dao);
    }
}
