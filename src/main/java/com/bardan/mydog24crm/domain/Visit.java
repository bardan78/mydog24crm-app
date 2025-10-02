package com.bardan.mydog24crm.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "VISIT")
public class Visit extends Super {

    public enum ServiceType {
        FULL,
        STRZ,
        TRYM,
        HIG
    }

    public enum Knife {
        L1_5,
        L3_5,
        L6_5,
        L9_5,
        L13
    }

    @ManyToOne
    @JoinColumn(name="DOG_ID")
    private Dog dog;

    @Column(name = "VISIT_DATE", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime visitDate;

    @Column(name = "VISIT_HOUR", nullable = false)
    private String visitHour;

    @Column(name = "DESCRIPTION", length = 1024)
    private String description;

    private BigDecimal price;

    @Column(name = "SERVICE_TYPE")
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @Column(name = "KNIFE")
    @Enumerated(EnumType.STRING)
    private Knife knife;

    @Column(name = "WITH_HAIR")
    private Boolean withHair = false;

    // czas wizyty w minutach
    private Long duration;


}
