package com.egrikulas.pinsoft.domain.security.authentication.config;


import com.egrikulas.pinsoft.domain.security.user.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userService.getUserByEmail(email);

        return new CustomUserDetails(user);
    }
}
