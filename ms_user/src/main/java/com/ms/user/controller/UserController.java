package com.ms.user.controller;

import com.ms.user.dtos.UserRecordDto;
import com.ms.user.model.UserModel;
import com.ms.user.repository.UserRepository;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<UserModel>  listarUsuarios(){
        return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<UserModel> salvarUsuario(@RequestBody @Valid UserRecordDto  userRecordDto){

       var userModel = new UserModel();

        BeanUtils.copyProperties(userRecordDto, userModel);

        return  ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
    }

    @PutMapping("/{userId}")
    public UserModel alterarUsuario(@RequestBody @Valid UserModel  userModel){

        return  userRepository.save(userModel);
    }
}
