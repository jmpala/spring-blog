package dev.jmpalazzolo.springblog.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.jmpalazzolo.springblog.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	 Optional<User> findByEmail(@Param("email") String email);

	 Optional<User> findByUsername(@Param("username") String username);
}
