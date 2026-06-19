package com.jobHunt.service.Impl;

import com.jobHunt.dto.LoginDTO;
import com.jobHunt.dto.UserDTO;
import com.jobHunt.entity.User;
import com.jobHunt.exception.JobHuntException;
import com.jobHunt.repository.UserRepository;
import com.jobHunt.service.UserService;
import com.jobHunt.utility.Utilities;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserDTO userDTO) throws JobHuntException {
        Optional<User> optional = userRepository.findByEmail(userDTO.getEmail());
        if(optional.isPresent()) {
            throw new JobHuntException("USER_FOUND");
        }
        userDTO.setId(Utilities.getNextSequence("users"));
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = userDTO.toEntity();
        user = userRepository.save(user);
        return user.toDTO();
    }

    @Override
    public UserDTO loginUser(LoginDTO loginDTO) throws JobHuntException {
        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new JobHuntException("USER_NOT_FOUND"));
        if(!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new JobHuntException("INVALID_CREDENTIALS");
        }
        return user.toDTO();
    }

}
