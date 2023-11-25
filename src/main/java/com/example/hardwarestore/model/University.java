package com.example.hardwarestore.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class University {
    @NotBlank(message = "Название не может быть пустым")
    private String name;

    @NotBlank(message = "Местоположение не может быть пустым")
    private String location;

    @NotNull(message = "Год основания не может быть пустой")
    private Integer foundationYear;

    private String description;

    @NotNull(message = "Количество студентов не может быть пустым")
    private Integer totalStudents;
}
