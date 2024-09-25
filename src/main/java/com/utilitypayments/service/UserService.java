package com.utilitypayments.service;

import com.utilitypayments.dto.UserDTO;
import com.utilitypayments.exceptions.UserNotFoundException;
import com.utilitypayments.mapper.UserMapper;
import com.utilitypayments.models.UserEntity;
import com.utilitypayments.repo.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findUserByEmail(email);
        if (userEntity == null) {
            throw new UserNotFoundException("Пользователь не найден с email: " + email);
        }
        return UserMapper.toDTO(userEntity);
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
