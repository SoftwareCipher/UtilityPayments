package com.utilitypayments.mapper;

import com.utilitypayments.dto.UserDTO;
import com.utilitypayments.models.UserEntity;

public class UserMapper {

    public static UserDTO toDTO(UserEntity entity){
        if(entity == null) return null;

        UserDTO userDTO = new UserDTO();
        userDTO.setFullName(entity.getFullName());
        userDTO.setPhone(entity.getPhoneNumber());
        userDTO.setEmail(entity.getEmail());

        return userDTO;
    }

    public static UserEntity entity(UserDTO userDTO){
        if(userDTO == null) return null;

        UserEntity user = new UserEntity();
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhone());

        return user;
    }
}
