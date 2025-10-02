package com.bardan.mydog24crm.interfaces.rest.dto;

import com.bardan.mydog24crm.domain.Dog;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DogDto {

    private Long id;
    private String breed;
    private String name;
    private String ownerName;
    private String tel1;
    private String tel2;
    private String tel3;
    private String email;
    private LocalDateTime firstVisitDate;
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
        this.firstVisitDate = dog.getFirstVisitDate();
        this.visits = dog.getVisits().stream().map(VisitDto::new).collect(Collectors.toList());
    }

    // Getters for all fields

    public Long getId() {
        return id;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getTel1() {
        return tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public String getTel3() {
        return tel3;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getFirstVisitDate() {
        return firstVisitDate;
    }

    public List<VisitDto> getVisits() {
        return visits;
    }
}
