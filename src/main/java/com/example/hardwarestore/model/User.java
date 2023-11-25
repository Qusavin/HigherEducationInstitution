package com.example.hardwarestore.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    @NotBlank(message = "Поле не должно быть пустым")
    private String username;

    @NotBlank(message = "Поле не должно быть пустым")
    private String password;

    // остальные поля...

    // геттеры и сеттеры
}
