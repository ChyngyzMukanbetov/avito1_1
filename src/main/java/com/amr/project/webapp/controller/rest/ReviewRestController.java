package com.amr.project.webapp.controller.rest;

import com.amr.project.converter.ReviewConverter;
import com.amr.project.model.dto.ReviewDto;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewRestController {

    private final ReviewService reviewService;

    private final ReviewConverter reviewConverter;

    public ReviewRestController(ReviewService reviewService, ReviewConverter reviewConverter) {
        this.reviewService = reviewService;
        this.reviewConverter = reviewConverter;
    }

    // список модерированных отзывов для юзеров по товару
    @GetMapping("/items/{id}")
    public ResponseEntity<List<ReviewDto>> listForUsersModerated(@PathVariable Long id){
        List<ReviewDto> reviewDtoList = reviewConverter.toDtoList(
                reviewService.findAllModerated(id));

        return reviewDtoList != null
                ?new ResponseEntity<>(reviewDtoList, HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//        список неотмодерированных отзывов для модератора
//    Отключено на время тестирования до подключения security
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR')")
    @GetMapping("/admin")
    public ResponseEntity<List<ReviewDto>> listForAdminForModerate(){
        List<ReviewDto> reviewDtoList = reviewConverter.toDtoList(reviewService.findAllForModerator(false,true));

        return reviewDtoList != null
                ?new ResponseEntity<>(reviewDtoList, HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
// отмодерированные отзывы по id для юзеров
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> reviewByIdForUserModerated(@PathVariable Long id){
        ReviewDto reviewDto = reviewConverter.toDto(reviewService.findByIdModerate(id, true, true));

        return reviewDto!= null
                ?new ResponseEntity<>(reviewDto, HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    список всех отзывов
//    Отключено на время тестирования до подключения security
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR')")
    @GetMapping("/admin/all")
    public ResponseEntity<List<ReviewDto>> listForAdminAll(){
        List<ReviewDto> reviewDtoList = reviewConverter.toDtoList(reviewService.findAll());

        return reviewDtoList != null
                ?new ResponseEntity<>(reviewDtoList, HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


//    Отключено на время тестирования до подключения security
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR')")
    @GetMapping("/admin/all/{id}")
    public ResponseEntity<ReviewDto> reviewByIdForAdminAll(@PathVariable Long id){
        ReviewDto reviewDto = reviewConverter.toDto(reviewService.findById(id));

        return reviewDto!= null
                ?new ResponseEntity<>(reviewDto, HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    Отключено на время тестирования до подключения security
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR','USER')")
    @PostMapping
    public ResponseEntity<String> newReview(@RequestBody ReviewDto reviewDto,
                                            @AuthenticationPrincipal User user){
        reviewService.save(reviewDto, user);
        return new ResponseEntity<>("Saved successfully", HttpStatus.OK);
    }

//    Отключено на время тестирования до подключения security
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR')")
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> deleteReviewByIdByAdmin(@PathVariable Long id){
        reviewService.deleteByIdCascadeIgnore(id);
        return reviewService.existsById(id)
                ? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReviewByIdByUser(@PathVariable Long id,
                                                         @AuthenticationPrincipal User user){

//        Отключено на время тестирования до подключения security
//        if (reviewService.findById(id).getUser()==user){
        reviewService.deleteByIdCascadeIgnore(id);
//        }else {return new ResponseEntity<>(HttpStatus.FORBIDDEN);}
        return reviewService.existsById(id)
                ? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable Long id,
                                                  @RequestBody ReviewDto reviewDto,
                                                  @AuthenticationPrincipal User user){
        //        Отключено на время тестирования до подключения security
//        if (reviewService.findById(id).getUser()==user)
        {reviewService.update(reviewConverter.toModel(reviewDto));
        return new ResponseEntity<>(HttpStatus.OK);}
//        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }


    // список всех отзывов по id товара
    //    Отключено на время тестирования до подключения security
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR')")
    @GetMapping("/admin/items/{id}")
    public ResponseEntity<List<ReviewDto>> findAllReviewByItemId(@PathVariable Long id){
        List<ReviewDto> reviewDtoList=reviewConverter.toDtoList(reviewService.getReviewsByItemId(id));
        return reviewDtoList!=null
                ?new ResponseEntity<>(reviewDtoList, HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
