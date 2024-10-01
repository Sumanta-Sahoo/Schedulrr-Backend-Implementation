package com.schedulrr.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.schedulrr.Entity.Availability;
import com.schedulrr.Entity.Booking;
import com.schedulrr.Entity.Event;
import com.schedulrr.Entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private int statusCode;
    private String message;
    private String token;
    private String expirationTime;
    private UserDTO userDTO;
    private EventDTO eventDTO;
    private BookingDTO bookingDTO;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private AvailabilityDTO availabilityDTO;

    private List<EventDTO> eventDTOS;
    private List<BookingDTO> bookingDTOS;
    private List<AvailabilityDTO> availabilityDTOS;


}
