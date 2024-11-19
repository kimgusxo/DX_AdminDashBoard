package com.example.dx_admindashboard.user.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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

}
