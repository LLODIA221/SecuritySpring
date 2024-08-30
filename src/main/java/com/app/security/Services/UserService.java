package com.app.security.Services;




import com.app.security.Dto.UserDto;
import com.app.security.Models.User;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface UserService {
    User save (UserDto userDto);

    Optional<User> getUserById(Long id);

    Authentication loadUserByUsername(String name);
}
