package com.example.dx_admindashboard.entity.user.domain;

import com.example.dx_admindashboard.entity.order.domain.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USER_TB")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long userId;

    @NotNull
    @Column(name = "USER_EMAIL")
    private String userEmail;

    @NotNull
    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @NotNull
    @Column(name = "USER_NAME")
    private String userName;

    @NotNull
    @Column(name = "IS_SUBSCRIBE")
    private Boolean isSubscribe;

    @NotNull
    @Column(name = "USER_GENDER")
    private String userGender;

    @NotNull
    @Column(name = "USER_AGE")
    private Integer userAge;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList;

}
