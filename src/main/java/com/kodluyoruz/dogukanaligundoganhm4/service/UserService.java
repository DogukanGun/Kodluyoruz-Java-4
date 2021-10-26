package com.kodluyoruz.dogukanaligundoganhm4.service;


 import com.kodluyoruz.dogukanaligundoganhm4.exception.ApiException;
 import com.kodluyoruz.dogukanaligundoganhm4.model.dto.UserDto;
 import com.kodluyoruz.dogukanaligundoganhm4.model.entity.User;
 import com.kodluyoruz.dogukanaligundoganhm4.model.request.user.CreateUserRequest;
import com.kodluyoruz.dogukanaligundoganhm4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.dogukanaligundoganhm4.model.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> getUsers(){
        return USER_MAPPER.convertToUserDtoList(userRepository.findAll());
    }

    public UserDto getUser(int id){
        return USER_MAPPER.convertToUserDto(userRepository.findById(id).orElseThrow(()->new ApiException("Wrond user id", HttpStatus.BAD_GATEWAY)));
    }

    public UserDto createUser(CreateUserRequest createUserRequest){
        User user = USER_MAPPER.createUser(createUserRequest);
        return USER_MAPPER.convertToUserDto(userRepository.save(user));
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
