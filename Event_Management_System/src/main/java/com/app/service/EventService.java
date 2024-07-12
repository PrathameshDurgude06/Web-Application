package com.app.service;

import java.util.List;

import com.app.dto.EventDTO;
import com.app.entity.Event;

public interface EventService {

	Boolean addEvent(Event event);
	
	List<Event> getAllEvents();
	
	List<EventDTO> getAllEventsByDto();
	
	void deleteEventById(Long id);
	
	Boolean updateEvent(Event event);
	
	List<Event> getAllEventsByCity(String city);
}
