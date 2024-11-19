package com.example.dx_admindashboard.user.domain.dto;

import com.example.dx_admindashboard.user.domain.User;

public record UserDTO(
        Long userId,
        String userEmail,
        String userPassword,
        String userName,
        Boolean isSubscribe
) {
    public static UserDTO of(Long userId,
                             String userEmail,
                             String userPassword,
                             String userName,
                             Boolean isSubscribe) {
        return new UserDTO(userId, userEmail, userPassword, userName, isSubscribe);
    }
    public static UserDTO from(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getUserEmail(),
                user.getUserPassword(),
                user.getUserName(),
                user.getIsSubscribe()
        );
    }
    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userEmail(userEmail)
                .userPassword(userPassword)
                .userName(userName)
                .isSubscribe(isSubscribe)
                .build();
    }
}