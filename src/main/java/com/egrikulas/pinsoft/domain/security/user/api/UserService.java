package com.egrikulas.pinsoft.domain.security.user.api;

public interface UserService {
    UserDto getUserById(String id);
    UserDto updateUser(String id, UserDto dto);
}
