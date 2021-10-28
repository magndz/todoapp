package com.app.service;

import com.app.domain.User;
import com.app.domain.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers(){
        return userRepository.findAll().stream().map(this::mapper).collect(Collectors.toList());
        //return userRepository.findById((long) 1).stream().map(this::mapper).collect(Collectors.toList());
    }

    public void register(UserDto userDto){
        userRepository.save(modelMapper.map(userDto, User.class));
    }

    private UserDto mapper(User user){
        return (modelMapper.map(user, UserDto.class));
    }
}
