package com.amr.project.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column
    private String textMessage;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User sender;


    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User recipient;


    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Chat chat;

    private boolean viewed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Message message = (Message) o;
        return id != null && Objects.equals(id, message.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
