package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long event_id;
	
	@NotBlank
	private String client_name;
	
	@NotBlank
	private String city;
	
	@Future
	private LocalDateTime date_of_booking;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Type event_type;
	
	@NotBlank
	@Size(min=10,max=10)
	private String contact_no;
	
	@NotNull
	private double budget;
	
	
}
