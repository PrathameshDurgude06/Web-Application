package com.app.dto;

import java.time.LocalDateTime;

import com.app.entity.Category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RailwayDTO {
	//Name, Category, Start_time, End_time, Fee
	
	private String name;
	private Category category;
	private LocalDateTime start_time;
	private LocalDateTime end_time;
}
