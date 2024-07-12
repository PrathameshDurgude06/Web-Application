package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.dto.RailwayDTO;
import com.app.entity.Category;
import com.app.entity.Railway;
import com.app.repository.RailwayRepo;

@Service
@Transactional
public class RailwayServiceImpl implements RailwayService{
	
	public RailwayServiceImpl() {
		System.out.println("in service constr");
	}
	
	@Autowired
	RailwayRepo railwayRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String addRailway(Railway railway) throws InvalidCredentialsException{
		if(railway.getStart_time().isAfter(railway.getEnd_time())) {
			throw new InvalidCredentialsException("Start time is After end time");
		}
		railwayRepo.save(railway);
		return "Railway Added";
	}

	@Override
	public List<Railway> display() {
		return railwayRepo.findAll();
	}
	
	@Override
	public String deleteRailwayById(Long id) {
		railwayRepo.deleteById(id);
		return "Railway deleted by id";
	}

	@Override
	public void deleteRailwayByName(String name) {
		railwayRepo.deleteAll(railwayRepo.findByName(name));
		
	}

	@Override
	public List<Railway> searchByName(Category category) {
		return railwayRepo.searchByCategory(category);
	}

	/*
	 * @Override public List<Railway> sortByName() { return
	 * railwayRepo.sortByName(); }
	 */

	
	@Override
	public List<RailwayDTO> getAllRailways() {
		return railwayRepo.findAll()
				.stream()
				.map(railway -> 
				mapper.map(railway,RailwayDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<Railway> findAllByOrderByNameAsc() {
		return railwayRepo.findAllByOrderByNameAsc();
	}

	@Override
	public void updatedetails(Railway railway) {
		Railway railway2 = railwayRepo.findById(railway.getId()).get();
		
		if(railway2!=null) {
			railwayRepo.save(railway);
		}
		
	}

}
