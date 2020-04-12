package dev.jmpalazzolo.springblog.repositories;

import org.springframework.data.repository.CrudRepository;

import dev.jmpalazzolo.springblog.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
