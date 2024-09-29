package com.schedulrr.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "availability")
public class Availability{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private int timeGap;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "availability", cascade = CascadeType.ALL)
    private List<DayAvailability> dayAvailabilities;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
