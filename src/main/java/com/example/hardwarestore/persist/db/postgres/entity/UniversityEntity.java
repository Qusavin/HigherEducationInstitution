package com.example.hardwarestore.persist.db.postgres.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class UniversityEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @NonNull
    private String name;

    @NonNull
    private String location;

    @NonNull
    private Integer foundationYear;

    @Nullable
    private String description;

    @NonNull
    private Integer totalStudents;
}
