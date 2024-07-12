package com.app.dto;

import com.app.entity.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class EventDTO {

	private String client_name;
	private Type event_type;
}
