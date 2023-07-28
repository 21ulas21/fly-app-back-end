package com.egrikulas.pinsoft.domain.security.authentication.api;

import com.egrikulas.pinsoft.domain.security.authentication.impl.AuthenticationRequest;
import com.egrikulas.pinsoft.domain.security.authentication.impl.AuthenticationResponse;
import com.egrikulas.pinsoft.domain.security.user.api.UserDto;
import com.egrikulas.pinsoft.domain.security.user.impl.UserRequest;


public interface AuthenticationService {

    AuthenticationResponse login(AuthenticationRequest request);
    UserDto register(UserRequest request);

}
