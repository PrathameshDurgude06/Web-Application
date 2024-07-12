package com.app.service;

import java.util.List;

import com.app.dto.RailwayDTO;
import com.app.entity.Category;
import com.app.entity.Railway;



public interface RailwayService {
	
	String addRailway(Railway railway);
	
	String deleteRailwayById(Long id);
	
	List<Railway> display();
	
	List<RailwayDTO> getAllRailways();
	
	void deleteRailwayByName(String name);
	
	List<Railway> searchByName(Category category);
	
	//List<Railway> sortByName();
	List<Railway> findAllByOrderByNameAsc();
	
	void updatedetails(Railway railway);

}
