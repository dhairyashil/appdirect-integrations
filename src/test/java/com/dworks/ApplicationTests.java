package com.dworks;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dworks.dto.model.AddressDTO;
import com.dworks.dto.model.UserDTO;
import com.dworks.repository.UserRepository;
import com.dworks.restcontroller.UserCRUDController;
import com.dworks.security.CustomOAuthProviderProcessingFilter;
import com.dworks.service.UserCRUDService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	private MockMvc mockMvc;

	@Mock
	private UserCRUDService userCRUDService;

	@Mock
	private UserRepository userRepository;

	@Mock
	private CustomOAuthProviderProcessingFilter customFilter;

	@InjectMocks
	private UserCRUDController userCrudController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userCrudController).addFilters(customFilter).build();
	}

	@Test
	public void createUser() throws Exception {

		UserDTO user = new UserDTO();
		user.setEmail("dhairyashil.bankar@gmail.com");
		user.setFirstName("dhairyashil");
		user.setLanguage("English");
		user.setLastName("Bankar");
		user.setOpenId(UUID.randomUUID().toString());
		user.setUuid(UUID.randomUUID().toString());

		AddressDTO address = new AddressDTO();
		address.setCity("Pune");
		address.setCountry("India");
		address.setPhone("9970355688");
		address.setState("Maharashtra");
		address.setZip("411038");
		
		user.setAddress(address);

		when(userCRUDService.saveOrUpdateUser(user)).thenReturn(user);

		mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andExpect(status().isOk());
		
		verifyNoMoreInteractions(userCRUDService);
	}
	
	@Test
	public void updateUser() throws Exception {

		UserDTO user = new UserDTO();
		user.setId(2L);
		user.setEmail("dhairyashil.bankar@citruspay.com");
		user.setFirstName("DHAIRASHIL");
		user.setLanguage("FRENCH");
		user.setLastName("BANKAR");
		user.setOpenId(UUID.randomUUID().toString());
		user.setUuid(UUID.randomUUID().toString());

		AddressDTO address = new AddressDTO();
		address.setCity("PUNE");
		address.setCountry("India");
		address.setPhone("9970355688");
		address.setState("Maharashtra");
		address.setZip("411038");
		
		user.setAddress(address);

		when(userCRUDService.saveOrUpdateUser(user)).thenReturn(user);

		mockMvc.perform(put("/user").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andExpect(status().isOk());
		
		verifyNoMoreInteractions(userCRUDService);
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
