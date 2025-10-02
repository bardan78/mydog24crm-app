package com.bardan.mydog24crm.interfaces.rest.dto;

import com.bardan.mydog24crm.domain.Dog;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DogDto {

    private Long id;
    private String breed;
    private String name;
    private String ownerName;
    private String tel1;
    private String tel2;
    private String tel3;
    private String email;
    private LocalDate firstVisitDate;
    private List<VisitDto> visits;

    public DogDto(Dog dog) {
        this.id = dog.getId();
        this.breed = dog.getBreed();
        this.name = dog.getName();
        this.ownerName = dog.getOwnerName();
        this.tel1 = dog.getTel1();
        this.tel2 = dog.getTel2();
        this.tel3 = dog.getTel3();
        this.email = dog.getEmail();
        this.firstVisitDate = dog.getFirstVisitDate().toLocalDate();
        this.visits = dog.getVisits().stream().map(VisitDto::new).collect(Collectors.toList());
    }
}
