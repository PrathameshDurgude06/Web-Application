package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.EventDTO;
import com.app.entity.Event;
import com.app.repository.EventRepository;

@Service
@Transactional
public class EventServiceImpl implements EventService{
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Boolean addEvent(Event event) {
		if(event != null) {
			eventRepository.save(event);
			return true;
		}
		return false;
	}

	@Override
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public List<EventDTO> getAllEventsByDto() {
		return eventRepository.findAll()
				.stream()
				.map(event ->
				modelMapper.map(event,EventDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteEventById(Long id) {
		eventRepository.deleteById(id);
		
	}

	@Override
	public Boolean updateEvent(Event event) {
		Event exevent=eventRepository.findById(event.getEvent_id()).get();
		if(exevent != null) {
			eventRepository.save(event);
			return true;
		}
		return false;
		
	}

	@Override
	public List<Event> getAllEventsByCity(String city) {
		return eventRepository.findAllByCity(city);
	}
	

}
