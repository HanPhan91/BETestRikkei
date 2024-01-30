package com.test.service.user;

import com.test.model.User;
import com.test.model.dto.UserCreateReqDTO;
import com.test.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User, String>, UserDetailsService {

    User getByUsername(String username);

    Optional<User> findByUsername(String username);

    User create(UserCreateReqDTO userCreateReqDTO);
}
