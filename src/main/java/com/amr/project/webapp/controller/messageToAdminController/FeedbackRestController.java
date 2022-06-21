package com.amr.project.webapp.controller.messageToAdminController;

import com.amr.project.model.dto.FeedbackDto;
import com.amr.project.model.entity.User;
import com.amr.project.service.impl.FeedbackServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback/")
public class FeedbackRestController {

    private final FeedbackServiceImpl feedbackService;

    public FeedbackRestController(FeedbackServiceImpl feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public ResponseEntity<List<FeedbackDto>> getAllFeedback() {
        List<FeedbackDto> feedbackDtos = feedbackService.findDtoAll();

        return feedbackDtos != null
                ? new ResponseEntity<>(feedbackDtos, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDto> feedbackById(@PathVariable Long id) {
        FeedbackDto feedbackDto = feedbackService.findDtoById(id);

        return feedbackDto != null
                ? new ResponseEntity<>(feedbackDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedbackById(@PathVariable Long id) {
        feedbackService.deleteByIdCascadeIgnore(id);

        return feedbackService.existsById(id)
                ? new ResponseEntity<>("unsucces delete", HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>("deleted succes", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveNewFeedback(@RequestBody FeedbackDto feedbackDto,
                                                  @AuthenticationPrincipal User user) {
        feedbackService.persist(feedbackDto, user);

        return new ResponseEntity<>("Feedback saved", HttpStatus.OK);
    }

}
