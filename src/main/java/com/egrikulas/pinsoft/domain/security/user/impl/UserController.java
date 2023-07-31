package com.egrikulas.pinsoft.domain.security.user.impl;

import com.egrikulas.pinsoft.domain.security.user.api.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable(value = "id") String id){
        var result = service.getUserById(id);
        return ResponseEntity.ok(UserResponse.toResponse(result));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable(value = "id") String id,
                                                   @RequestBody UserRequest request){
        var result = service.updateUser(id,request.toDto());
        return ResponseEntity.ok(UserResponse.toResponse(result));
    }
    @GetMapping()
    public ResponseEntity<UserResponse> getUser(){
        var result = service.getUser();
        return ResponseEntity.ok(UserResponse.toResponse(result));
    }




}
