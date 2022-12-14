package com.amr.project.model.entity;

import com.amr.project.model.entity.report.SalesHistory;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    //TODO: проверить "правильность" параметра unique (могут быть товары с одинаковыми наименованиями у разных Shops, Users, CartItems)
    @Column(name = "name", unique = false)
    private String name;

    @Column(name = "base_price")
    private BigDecimal basePrice;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "count")
    private int count;

    @Column(name = "rating")
    private double rating;


    private String description;
    private int discount;

    public Item(Long id, String name, BigDecimal basePrice, BigDecimal price,
                int count, double rating, String description, int discount) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.price = price;
        this.count = count;
        this.rating = rating;
        this.description = description;
        this.discount = discount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private CartItem cartItem;


    @OneToMany(
            cascade = {CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
                    CascadeType.DETACH},
            orphanRemoval = false
    )
    @JoinColumn(name = "item_id")
    @ToString.Exclude
    private List<Image> images;


    @OneToMany(
            mappedBy = "item",
            cascade = {CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
                    CascadeType.DETACH},
            orphanRemoval = false
    )
    @ToString.Exclude
    private List<Review> reviews;


    @ManyToMany(mappedBy = "items")
    @ToString.Exclude
    private List<Favorite> favorites;


    @ManyToMany(mappedBy = "itemsInOrder")
    @OrderBy("orderDate ASC")
    @ToString.Exclude
    private List<Order> orders = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Shop shop;


    @OneToMany(
            mappedBy = "item",
            cascade = {CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
                    CascadeType.DETACH},
            orphanRemoval = false
    )
    @ToString.Exclude
    private List<SalesHistory> history;


    public void setImages(List<Image> images) {
        if (this.images == null) {
            this.images = new ArrayList<>();
        }
        this.images.clear();
        if (images != null) {
            this.images.addAll(images);
        }
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

    public void setSalesHistory(List<SalesHistory> history) {
        if (this.history == null) {
            this.history = new ArrayList<>();
        }
        this.history.clear();
        if (history != null) {
            this.history.addAll(history);
        }
    }

    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;
    private boolean isPretendedToBeDeleted;


    public boolean isPretendedToBeDeleted() {
        return isPretendedToBeDeleted;
    }

    public void setPretendedToBeDeleted(boolean pretendedToBeDeleted) {
        isPretendedToBeDeleted = pretendedToBeDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Item item = (Item) o;
        return id != null && Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
