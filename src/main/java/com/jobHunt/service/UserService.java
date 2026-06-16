package com.jobHunt.service;

import com.jobHunt.dto.UserDTO;
import com.jobHunt.exception.JobHuntException;

public interface UserService {

    UserDTO registerUser(UserDTO userDTO) throws JobHuntException;

}
