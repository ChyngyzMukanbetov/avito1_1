package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ChatDAO;
import com.amr.project.model.entity.Chat;
import org.springframework.stereotype.Repository;

@Repository
public class ChatDAOImpl extends ReadWriteDaoImpl<Chat, Long> implements ChatDAO {
}
