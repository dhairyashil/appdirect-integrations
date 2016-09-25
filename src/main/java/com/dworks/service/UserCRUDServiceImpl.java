package com.dworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dworks.dto.model.BaseResponse;
import com.dworks.dto.model.CRUDResponse;
import com.dworks.dto.model.UserDTO;
import com.dworks.enums.ResponseCodes;
import com.dworks.model.User;
import com.dworks.repository.UserRepository;

@Service
public class UserCRUDServiceImpl implements UserCRUDService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public BaseResponse saveOrUpdateUser(UserDTO userDto) {
		User user = null;
		
		Long id = userDto.getId();
		String _id = null;
		if (id != null) {
			user = repository.findOne(userDto.getId());

			if (user == null) {
				_id = (id != null) ? id.toString() : null;
				return new CRUDResponse(false, ResponseCodes.USER_NOT_FOUND_ERROR_CODE,
						ResponseCodes.USER_NOT_FOUND_ERROR_MESSAGE.concat(_id));
			}
		}

		user = repository.save(new User(userDto));

		UserDTO _userDTO = new UserDTO(user);
		return _userDTO;
	}

	@Override
	public BaseResponse findUserById(Long id) {
		User user = repository.findOne(id);
		if (user == null) {
			String _id = (id != null) ? id.toString() : null;
			return new CRUDResponse(false, ResponseCodes.USER_NOT_FOUND_ERROR_CODE,
					ResponseCodes.USER_NOT_FOUND_ERROR_MESSAGE.concat(_id));
		}

		UserDTO _userDTO = new UserDTO(user);
		return _userDTO;
	}

	@Override
	public BaseResponse deleteUserById(Long id) {
		User user = repository.findOne(id);
		String _id = null;
		if (user == null) {
			_id = (id != null) ? id.toString() : null;
			return new CRUDResponse(false, ResponseCodes.USER_NOT_FOUND_ERROR_CODE,
					ResponseCodes.USER_NOT_FOUND_ERROR_MESSAGE.concat(_id));
		} else {
			_id = (id != null) ? id.toString() : null;
		}
		repository.delete(user);

		return new CRUDResponse(ResponseCodes.USER_DELETED_SUCCESS.concat(_id), true);
	}
}
