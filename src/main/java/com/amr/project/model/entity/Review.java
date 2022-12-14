package com.amr.project.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "dignity")
    private String dignity; //плюсы

    @Column(name = "flaw")
    private String flaw; //минусы

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date date;

    @Column(name = "rating")
    private int rating;

    public Review(Long id, String dignity, String flaw, String text, Date date, int rating) {
        this.id = id;
        this.dignity = dignity;
        this.flaw = flaw;
        this.text = text;
        this.date = date;
        this.rating = rating;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Shop shop;


    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Item item;


    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Review review = (Review) o;
        return id != null && Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
