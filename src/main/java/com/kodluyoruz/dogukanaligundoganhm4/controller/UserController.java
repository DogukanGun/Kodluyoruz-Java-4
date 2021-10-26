package com.kodluyoruz.dogukanaligundoganhm4.controller;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.UserDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.user.CreateUserRequest;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.user.UpdateUserRequest;
import com.kodluyoruz.dogukanaligundoganhm4.service.AuthService;
import com.kodluyoruz.dogukanaligundoganhm4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping
    public UserDto createUser(@RequestBody CreateUserRequest createUserRequest){
        return userService.createUser(createUserRequest);
    }

    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public UserDto getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @PatchMapping("update-user/{id}")
    public void resetPassword(@PathVariable int id,@RequestBody UpdateUserRequest updateUserRequest){
        authService.resetPassword(id,updateUserRequest);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

}
