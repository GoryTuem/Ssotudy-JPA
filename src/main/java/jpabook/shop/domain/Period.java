package jpabook.shop.domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;
public class Period {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Period(){

    }
}
