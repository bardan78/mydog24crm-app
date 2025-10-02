package com.bardan.mydog24crm.interfaces.rest.dto;

import com.bardan.mydog24crm.domain.Dog;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A Data Transfer Object representing a Dog and its visits.
 * This class is immutable.
 */
@Value // Lombok annotation for immutable value objects
public class DogDto {

    Long id;
    String breed;
    String name;
    String ownerName;
    String tel1;
    String tel2;
    String tel3;
    String email;
    LocalDate firstVisitDate;
    List<VisitDto> visits;

    /**
     * Factory method to create a DogDto from a Dog entity.
     * @param dog The Dog entity.
     * @return A new DogDto instance.
     */
    public static DogDto from(Dog dog) {
        List<VisitDto> visitDtos = dog.getVisits().stream()
                .map(VisitDto::from) // Using the factory method from VisitDto
                .collect(Collectors.toList());

        return new DogDto(
                dog.getId(),
                dog.getBreed(),
                dog.getName(),
                dog.getOwnerName(),
                dog.getTel1(),
                dog.getTel2(),
                dog.getTel3(),
                dog.getEmail(),
                dog.getFirstVisitDate() != null ? dog.getFirstVisitDate().toLocalDate() : null,
                visitDtos
        );
    }
}
