package com.egrikulas.pinsoft.domain.security.authentication.impl;


import com.egrikulas.pinsoft.domain.security.authentication.api.AuthenticationService;
import com.egrikulas.pinsoft.domain.security.authentication.jwt.JwtService;
import com.egrikulas.pinsoft.domain.security.user.api.UserDto;
import com.egrikulas.pinsoft.domain.security.user.impl.User;
import com.egrikulas.pinsoft.domain.security.user.impl.UserRequest;
import com.egrikulas.pinsoft.domain.security.user.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        var user = userService.getUserByEmail(request.getEmail());
        var token = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public UserDto register(UserRequest request) {
        User user =  userService.toEntity(new User(), request.toDto());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userService.createUser(user);
    }
}
