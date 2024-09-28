package com.schedulrr.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "availability")
public class Availability extends Auditable{

    private Long Id;
    private int timeGap;

    @OneToMany(mappedBy = "availability", cascade = CascadeType.ALL)
    private List<DayAvailability> dayAvailabilities;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
