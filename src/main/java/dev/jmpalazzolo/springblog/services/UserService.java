package dev.jmpalazzolo.springblog.services;

import java.util.Optional;

import dev.jmpalazzolo.springblog.models.User;


public interface UserService {

	Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(User user);
}
