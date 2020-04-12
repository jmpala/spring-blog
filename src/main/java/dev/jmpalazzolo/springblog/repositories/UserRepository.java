package dev.jmpalazzolo.springblog.repositories;

import org.springframework.data.repository.CrudRepository;

import dev.jmpalazzolo.springblog.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
