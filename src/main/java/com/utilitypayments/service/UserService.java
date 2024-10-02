package com.utilitypayments.service;

import com.utilitypayments.dto.UserDTO;
import com.utilitypayments.mapper.UserMapper;
import com.utilitypayments.models.UserEntity;
import com.utilitypayments.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDTO)
                .toList();
    }

    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = userMapper.toUser(userDTO);
        UserEntity saveUser = userRepository.save(userEntity);
        return userMapper.toUserDTO(saveUser);

    }
}
