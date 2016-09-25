package com.dworks.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dworks.dto.model.BaseResponse;
import com.dworks.dto.model.UserDTO;
import com.dworks.service.UserCRUDService;

/**
 * @author dhairyashil
 *
 */
@RestController
@RequestMapping("/user")
public class UserCRUDController {

	@Autowired
	private UserCRUDService userCRUDService;
	
	@RequestMapping(method = RequestMethod.POST)
    public BaseResponse saveUser(@RequestBody UserDTO userDTO) {
		return userCRUDService.saveOrUpdateUser(userDTO);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public BaseResponse updateUser(@RequestBody UserDTO userDTO) {
		return userCRUDService.saveOrUpdateUser(userDTO);
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BaseResponse fetchUser(@PathVariable("id") Long id) {
		return userCRUDService.findUserById(id);
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public BaseResponse deleteUser(@PathVariable("id") Long id) {
		return userCRUDService.deleteUserById(id);
    }

}
