package com.egrikulas.pinsoft.domain.security.user.impl;


import com.egrikulas.pinsoft.domain.security.user.api.UserDto;
import com.egrikulas.pinsoft.domain.security.user.api.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository repository;


    public UserDto createUser(User user){
        return toDto(repository.save(user));
    }
    @Override
    public UserDto getUserById(String id) {
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return toDto(user);
    }
    public UserDto getUserByEmail(String email) {
        User user = repository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
        return toDto(user);
    }
    public User getUserEntityById(String id){
        return  repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public User getUserEntityByEmail(String email){
        return repository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public UserDto updateUser(String id, UserDto userDto) {
        return repository.findById(id)
                .map(user -> toEntity(user,userDto))
                .map(repository::save)
                .map(this::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public UserDto getUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(username);
    }

    public User toEntity(User user, UserDto dto){
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setGender(dto.getGender());
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setCitizen(dto.getCitizen());
        user.setIndentificationNumber(dto.getIndentificationNumber());
        user.setCountry(dto.getCountry());
        user.setCity(dto.getCity());
        return user;
    }

    public UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phone(user.getPhone())
                .gender(user.getGender())
                .dateOfBirth(user.getDateOfBirth())
                .citizen(user.getCitizen())
                .indentificationNumber(user.getIndentificationNumber())
                .country(user.getCountry())
                .city(user.getCity())
                .build();
    }
}
