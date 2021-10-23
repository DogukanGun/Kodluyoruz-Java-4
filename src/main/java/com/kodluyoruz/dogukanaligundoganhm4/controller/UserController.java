package com.kodluyoruz.dogukanaligundoganhm4.controller;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.UserDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateUserRequest;
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

    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public UserDto getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @PatchMapping("reset-password")
    public void resetPassword(@RequestBody UpdateCreateUserRequest updateCreateUserRequest){
        authService.resetPassword(updateCreateUserRequest);
    }

    @PatchMapping("change-email")
    public void changeEmail(@RequestBody UpdateCreateUserRequest updateCreateUserRequest){
        authService.changeEmail(updateCreateUserRequest);
    }

}
