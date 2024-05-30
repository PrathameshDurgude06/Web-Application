package com.blogs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogs.dto.CategoryDTO;

@SpringBootTest // annotaion for the spring boot test frmwork to enable 
//all spring beans including controller,service and dao beans
class CategoryServiceTest {
	@Autowired
	private CategoryService categoryService;

	@Test
	void test() {
		assertNotNull(categoryService);
	}
	@Test
	void testgetAllCategories() {
		List<CategoryDTO> list = categoryService.getAllCategories();
		assertEquals(4,list.size());
		//not good pattern!(should not display any 
		list.forEach(System.out::println);
	}
	

	
}
