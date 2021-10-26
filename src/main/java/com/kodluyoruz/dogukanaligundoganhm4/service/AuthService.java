package com.kodluyoruz.dogukanaligundoganhm4.service;


import com.kodluyoruz.dogukanaligundoganhm4.exception.ApiException;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.User;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.user.UpdateUserRequest;
import com.kodluyoruz.dogukanaligundoganhm4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.kodluyoruz.dogukanaligundoganhm4.model.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public void resetPassword(int id,UpdateUserRequest updateUserRequest){
        User user = userRepository.findById(id).orElseThrow(()->new ApiException("Wrong Password", HttpStatus.BAD_GATEWAY));
        if (!user.getPassword().equals(updateUserRequest.getOldPassword())){
            throw new ApiException("Curren password is wrong",HttpStatus.NOT_FOUND);
        }
        USER_MAPPER.updateUser(user,updateUserRequest);
        userRepository.save(user);
    }

}
