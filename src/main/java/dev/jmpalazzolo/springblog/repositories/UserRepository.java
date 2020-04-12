package dev.jmpalazzolo.springblog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import dev.jmpalazzolo.springblog.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 Optional<User> findByEmail(@Param("email") String email);

	 Optional<User> findByUsername(@Param("username") String username);
}
