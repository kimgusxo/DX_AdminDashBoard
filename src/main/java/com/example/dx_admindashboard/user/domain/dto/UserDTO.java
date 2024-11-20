package com.example.dx_admindashboard.user.domain.dto;

import com.example.dx_admindashboard.user.domain.User;

public record UserDTO(
        Long userId,
        String userEmail,
        String userPassword,
        String userName,
        Boolean isSubscribe,
        String userGender,
        Integer userAge
) {
    public static UserDTO of(Long userId,
                             String userEmail,
                             String userPassword,
                             String userName,
                             Boolean isSubscribe,
                             String userGender,
                             Integer userAge) {
        return new UserDTO(userId, userEmail, userPassword, userName, isSubscribe, userGender, userAge);
    }
    public static UserDTO from(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getUserEmail(),
                user.getUserPassword(),
                user.getUserName(),
                user.getIsSubscribe(),
                user.getUserGender(),
                user.getUserAge()
        );
    }
    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userEmail(userEmail)
                .userPassword(userPassword)
                .userName(userName)
                .isSubscribe(isSubscribe)
                .userGender(userGender)
                .userAge(userAge)
                .build();
    }
}