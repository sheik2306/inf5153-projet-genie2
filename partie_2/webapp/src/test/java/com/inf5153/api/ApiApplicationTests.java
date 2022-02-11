package com.inf5153.api;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

import com.inf5153.api.models.Address;
import com.inf5153.api.repositories.AddressRepository;
import com.inf5153.api.services.AddressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java.util.Optional;

@SpringBootTest
class ApiApplicationTests {

	@Autowired
	AddressService addressService;

	@MockBean
	private AddressRepository addressRepository;

	@Test
	void contextLoads() {
		assertTrue(true);
	}

	@Test
	void fetchOneById() {

		Address address = new Address("234","Dubois");
		doReturn(Optional.of(address)).when(addressRepository).findById(1);

		//Service call
		Optional<Address> add = Optional.ofNullable(addressService.fetchOneById(1));

		Assertions.assertTrue(add.isPresent(), "Widget was not found");
		Assertions.assertSame(add.get(), address, "The widget returned was not the same as the mock");
	}

}
