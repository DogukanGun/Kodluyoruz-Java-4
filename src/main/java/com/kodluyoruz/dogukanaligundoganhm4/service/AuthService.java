package com.kodluyoruz.dogukanaligundoganhm4.service;


import com.kodluyoruz.dogukanaligundoganhm4.exception.ApiException;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.User;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateUserRequest;
import com.kodluyoruz.dogukanaligundoganhm4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.kodluyoruz.dogukanaligundoganhm4.model.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public void resetPassword(UpdateCreateUserRequest updateCreateUserRequest){
        User user = userRepository.findById(updateCreateUserRequest.getId()).orElseThrow(()->new ApiException("Wrong Password", HttpStatus.BAD_GATEWAY));
        if (!user.getPassword().equals(updateCreateUserRequest.getOldPassword())){
            throw new ApiException("Curren password is wrong",HttpStatus.NOT_FOUND);
        }
        user.setPassword(updateCreateUserRequest.getNewPassword());
    }

    public void changeEmail(UpdateCreateUserRequest updateCreateUserRequest){
        User user = userRepository.findById(updateCreateUserRequest.getId()).orElseThrow(()->new ApiException("Wrong Password", HttpStatus.BAD_GATEWAY));
        user.setEmail(updateCreateUserRequest.getEmail());
    }
}
