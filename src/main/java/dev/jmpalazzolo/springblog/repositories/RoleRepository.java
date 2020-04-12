package dev.jmpalazzolo.springblog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.jmpalazzolo.springblog.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByRole(@Param("role") String role);
}
