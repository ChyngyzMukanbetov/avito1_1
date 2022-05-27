package com.amr.project.model.entity;

import com.amr.project.model.enums.Gender;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class UserInfo {

    //TODO удалить и объединить с сущностью User

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @ToString.Exclude
    private String phone;
    @ToString.Exclude
    private String firstName;
    @ToString.Exclude
    private String lastName;
    @ToString.Exclude
    private int age;
    @Enumerated(EnumType.STRING)
    @ToString.Exclude
    private Gender gender;
    @ToString.Exclude
    private Calendar birthday;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserInfo userInfo = (UserInfo) o;
        return id != null && Objects.equals(id, userInfo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
