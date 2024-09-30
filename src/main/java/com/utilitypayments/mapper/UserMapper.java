package com.utilitypayments.mapper;

import com.utilitypayments.dto.UserDTO;
import com.utilitypayments.models.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(UserEntity user);

    UserEntity toUser(UserDTO userDTO);
}
