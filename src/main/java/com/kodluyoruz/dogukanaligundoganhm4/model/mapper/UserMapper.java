package com.kodluyoruz.dogukanaligundoganhm4.model.mapper;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.UserDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.User;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.user.CreateUserRequest;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.user.UpdateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserDto convertToUserDto(User user);

    User convertToUser(UserDto userDto);

    User createUser(CreateUserRequest createUserRequest);

    void updateUser(@MappingTarget User user,UpdateUserRequest updateUserRequest);

    List<UserDto> convertToUserDtoList(List<User> users);
}
