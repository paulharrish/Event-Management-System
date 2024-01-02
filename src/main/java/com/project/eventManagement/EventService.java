package com.project.eventManagement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.aspectj.apache.bcel.generic.LOOKUPSWITCH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {

        if (event.getDate() == null) {
            event.setDate(LocalDate.now().toString());
        }
        if (event.getTime() == null) {
            event.setTime(LocalTime.now().toString());
        }

        if (event.getTitle() == null || event.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Event title cannot be empty");

        }
        return eventRepository.save(event);

    }

    public Event editEvent(Event event) {

        // logic for editing the events
        return eventRepository.save(event);
    }

    public void cancelEvent(Long eventId) {

        // logic for cancelling the events.
        eventRepository.deleteById(eventId);
    }

    public Optional<Event> getEventbyId(Long eventId) {
        // logic
        return eventRepository.findById(eventId);
    }

}
