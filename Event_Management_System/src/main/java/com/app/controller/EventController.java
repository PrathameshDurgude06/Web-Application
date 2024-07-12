package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EventDTO;
import com.app.entity.Event;
import com.app.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	
	public EventController() {
		System.out.println("In Event Constructor");	
	}
	
	@Autowired
	EventService eventService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addEvent(@RequestBody Event event){
		if(eventService.addEvent(event)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Event Added");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Event can not be added");
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Event>> getAllEvents(){
		List<Event> elist=eventService.getAllEvents();
		return ResponseEntity.status(HttpStatus.OK).body(elist);
	}
	
	@GetMapping("/payload")
	public ResponseEntity<List<EventDTO>> getAllEventsByDto(){
		List<EventDTO> dlist=eventService.getAllEventsByDto();
		return ResponseEntity.status(HttpStatus.OK).body(dlist);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		eventService.deleteEventById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Event Deleted");
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEvent(@RequestBody Event event){
		if(eventService.updateEvent(event)) {
			return ResponseEntity.status(HttpStatus.OK).body("Updated");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Updated");
		
	}
	
	@GetMapping("/getallbycity/{city}")
	public ResponseEntity<List<Event>> getAllEventsByCity(@PathVariable String city){
		List<Event> clist=eventService.getAllEventsByCity(city);
		return ResponseEntity.status(HttpStatus.OK).body(clist);
	}
}
