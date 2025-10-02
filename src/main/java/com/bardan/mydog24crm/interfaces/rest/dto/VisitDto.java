package com.bardan.mydog24crm.interfaces.rest.dto;

import com.bardan.mydog24crm.domain.Visit;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A Data Transfer Object representing a Visit.
 * This class is immutable.
 */
@Value // Lombok annotation for immutable value objects
public class VisitDto {

    Long id;
    LocalDate visitDate;
    String visitHour;
    String description;
    BigDecimal price;
    Visit.ServiceType serviceType;
    Visit.Knife knife;
    Boolean withHair;
    Long duration;

    /**
     * Factory method to create a VisitDto from a Visit entity.
     * @param visit The Visit entity.
     * @return A new VisitDto instance.
     */
    public static VisitDto from(Visit visit) {
        return new VisitDto(
                visit.getId(),
                visit.getVisitDate().toLocalDate(),
                visit.getVisitHour(),
                visit.getDescription(),
                visit.getPrice(),
                visit.getServiceType(),
                visit.getKnife(),
                visit.getWithHair(),
                visit.getDuration()
        );
    }
}
