package com.jobHunt.service.Impl;

import com.jobHunt.dto.UserDTO;
import com.jobHunt.entity.User;
import com.jobHunt.repository.UserRepository;
import com.jobHunt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = userDTO.toEntity();
        user = userRepository.save(user);
        return user.toDTO();
    }

}
