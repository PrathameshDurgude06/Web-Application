package com.blogs.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.blogs.entities.User;

@DataJpaTest //annotation to tell spring boot frmwork to enable 
//data jpa layer(i.e service |controller|
//modelmapper.. beans will not be activated)
@AutoConfigureTestDatabase(replace = Replace.NONE)
// to tell spring boot test frmwork Don't replace the application default DataSource(mysql)
class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Test //JUnit anno to indicate a test method
	void testFindByEmailAndPassword() {
		Optional<User> optional = userRepository.findByEmailAndPassword("a2@gmail.com", "2234");
		//assert methods args- expected, actual 
		//test case passes when expected matches the actual 
		//o.w fails
		assertEquals(2l, optional.get().getId());
	}

}
