package com.jobHunt.service.Impl;

import com.jobHunt.dto.UserDTO;
import com.jobHunt.entity.User;
import com.jobHunt.exception.JobHuntException;
import com.jobHunt.repository.UserRepository;
import com.jobHunt.service.UserService;
import com.jobHunt.utility.Utilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO registerUser(UserDTO userDTO) throws JobHuntException {
        userDTO.setId(Utilities.getNextSequence("users"));
        User user = userDTO.toEntity();
        user = userRepository.save(user);
        return user.toDTO();
    }

}
