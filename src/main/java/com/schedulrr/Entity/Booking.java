package com.schedulrr.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "booking")
public class Booking extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String additionalInfo;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String meetLink;
    private String googleEventId;

    @ManyToOne()
    @JoinColumn(name = "eventId", nullable = false)
    private Event event;
    @ManyToOne()
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}
