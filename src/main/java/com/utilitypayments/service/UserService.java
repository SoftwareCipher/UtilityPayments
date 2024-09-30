package com.utilitypayments.service;

import com.utilitypayments.dto.UserDTO;
import com.utilitypayments.exceptions.UserNotFoundException;
import com.utilitypayments.mapper.UserMapper;
import com.utilitypayments.models.UserEntity;
import com.utilitypayments.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findUserByEmail(email);
        if (userEntity == null) {
            throw new UserNotFoundException("Пользователь не найден с email: " + email);
        }
        return userMapper.toUserDTO(userEntity);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }
}
