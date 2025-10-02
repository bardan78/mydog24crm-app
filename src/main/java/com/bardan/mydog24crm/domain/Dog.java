package com.bardan.mydog24crm.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "DOG")
@Data
public class Dog extends Super {

    @Column(name="CLIENT_NUMBER")
    private Long clientNumber;

    private String breed;

    private String name;

    private String tel1;

    private String tel2;

    private String tel3;

    private String email;

    @Column(name = "OWNER_NAME")
    private String ownerName;

    @Column(name = "FIRST_VISIT_DATE", nullable = false)
    private LocalDateTime firstVisitDate;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="DOG_ID")
    @OrderBy("VISIT_DATE DESC")
    private List<Visit> visits = new ArrayList<>();

}
