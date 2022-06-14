package com.amr.project.model.entity;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Shop implements Serializable {

    private static final long serialVersionUID = 156977875169457L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column (unique = true)
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    @Column
    private String description;
    private int count;      //что за поле? Нет описания
    private double rating;


    @OneToMany(
            mappedBy = "shop",
            cascade = {CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
                    CascadeType.DETACH},
            orphanRemoval = false
    )
    @ToString.Exclude
    private List<Item> items;


    @OneToMany(
            mappedBy = "shop",
            cascade = {CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
                    CascadeType.DETACH},
            orphanRemoval = false
    )
    @ToString.Exclude
    private List<Review> reviews;


    @OneToOne(mappedBy = "shop", cascade = {CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH},
            fetch = FetchType.LAZY, optional = false)
    @ToString.Exclude
    private Image logo;


    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;


    @OneToOne(mappedBy = "shop", cascade = {CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH},
            fetch = FetchType.LAZY, optional = false)
    @ToString.Exclude
    private CartItem cartItem;


    @OneToMany(
            mappedBy = "shop",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    @ToString.Exclude
    private List<Feedback> feedbacks;


    @OneToMany(
            mappedBy = "shop",
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH},
            orphanRemoval = false)
    @ToString.Exclude
    private List<Discount> discounts;


    @ManyToMany(mappedBy = "shops")
    @ToString.Exclude
    private List<Favorite> favorites;


    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private City location;


    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    @JoinColumn(name = "shop_id")
    @ToString.Exclude
    private List<Coupon> coupons;


    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;
    private boolean isPretendedToBeDeleted;

    public boolean isPretendedToBeDeleted() {
        return isPretendedToBeDeleted;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Shop shop = (Shop) o;
        return id != null && Objects.equals(id, shop.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void setReviews(List<Review> reviews) {
        if (this.reviews == null) {
            this.reviews = new ArrayList<>();
        }
        this.reviews.clear();
        if (reviews != null) {
            this.reviews.addAll(reviews);
        }
    }

    public void setItems(List<Item> items) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.clear();
        if (items != null) {
            this.items.addAll(items);
        }
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        if (this.feedbacks == null) {
            this.feedbacks = new ArrayList<>();
        }
        this.feedbacks.clear();
        if (feedbacks != null) {
            this.feedbacks.addAll(feedbacks);
        }
    }

    public void setDiscounts(List<Discount> discounts) {
        if (this.discounts == null) {
            this.discounts = new ArrayList<>();
        }
        this.discounts.clear();
        if (discounts != null) {
            this.discounts.addAll(discounts);
        }
    }

    public void setFavorites(List<Favorite> favorites) {
        if (this.favorites == null) {
            this.favorites = new ArrayList<>();
        }
        this.favorites.clear();
        if (favorites != null) {
            this.favorites.addAll(favorites);
        }
    }

    public void setCoupons(List<Coupon> coupons) {
        if (this.coupons == null) {
            this.coupons = new ArrayList<>();
        }
        this.coupons.clear();
        if (coupons != null) {
            this.coupons.addAll(coupons);
        }
    }
}
