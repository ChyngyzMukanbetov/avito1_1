package com.amr.project.service.impl;

import com.amr.project.converter.FeedbackConverter;
import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.dto.FeedbackDto;
import com.amr.project.model.entity.Feedback;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.FeedbackService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackServiceImpl extends ReadWriteServiceImpl<Feedback, Long> implements FeedbackService {
    public FeedbackServiceImpl(ReadWriteDao<Feedback, Long> dao, FeedbackConverter feedbackConverter) {
        super(dao);
        this.feedbackConverter = feedbackConverter;
    }

    private final FeedbackConverter feedbackConverter;

    public List<FeedbackDto> findDtoAll() {
        List<Feedback> feedbacks =super.findAll();
        List<FeedbackDto> feedbackDtos = new ArrayList<>();
        for(Feedback feedback : feedbacks){
            feedbackDtos.add(findDtoById(feedback.getId()));
        }
        return feedbackDtos;
    }

    public FeedbackDto findDtoById(Long id) {
        Feedback feedback = super.findById(id);
        FeedbackDto feedbackDto= feedbackConverter.toDto(feedback);
        if (feedback.getUser()!=null){feedbackDto.setUserId(feedback.getUser().getId());}
        return feedbackDto;
    }

    @Transactional
    public Feedback persist(FeedbackDto entity, User user) {
        Feedback feedback = feedbackConverter.toModel(entity);
        if (user != null) {
            feedback.setUser(user);
            feedback.setUsername(user.getUsername());
        }
        feedback.setDateTime(LocalDateTime.now());


        return super.persist(feedback);
    }
}
