package com.dworks.service;

import com.dworks.dto.model.BaseResponse;
import com.dworks.dto.model.UserDTO;

public interface UserCRUDService {
	BaseResponse saveOrUpdateUser(UserDTO dto);
	BaseResponse findUserById(Long id);
	BaseResponse deleteUserById(Long id);
}
