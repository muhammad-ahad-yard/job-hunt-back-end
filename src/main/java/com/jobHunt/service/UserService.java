package com.jobHunt.service;

import com.jobHunt.dto.LoginDTO;
import com.jobHunt.dto.UserDTO;
import com.jobHunt.exception.JobHuntException;

public interface UserService {

    UserDTO registerUser(UserDTO userDTO) throws JobHuntException;

    UserDTO loginUser(LoginDTO loginDTO) throws JobHuntException;
}
