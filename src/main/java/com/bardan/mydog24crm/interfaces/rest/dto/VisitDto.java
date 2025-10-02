package com.bardan.mydog24crm.interfaces.rest.dto;

import com.bardan.mydog24crm.domain.Visit;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class VisitDto {

    private Long id;
    private LocalDate visitDate;
    private String visitHour;
    private String description;
    private BigDecimal price;
    private Visit.ServiceType serviceType;
    private Visit.Knife knife;
    private Boolean withHair;
    private Long duration;

    public VisitDto(Visit visit) {
        this.id = visit.getId();
        this.visitDate = visit.getVisitDate().toLocalDate();
        this.visitHour = visit.getVisitHour();
        this.description = visit.getDescription();
        this.price = visit.getPrice();
        this.serviceType = visit.getServiceType();
        this.knife = visit.getKnife();
        this.withHair = visit.getWithHair();
        this.duration = visit.getDuration();
    }

}
