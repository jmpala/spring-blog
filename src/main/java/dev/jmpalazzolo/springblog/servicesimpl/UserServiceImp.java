package dev.jmpalazzolo.springblog.servicesimpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.jmpalazzolo.springblog.models.Role;
import dev.jmpalazzolo.springblog.models.User;
import dev.jmpalazzolo.springblog.repositories.RoleRepository;
import dev.jmpalazzolo.springblog.repositories.UserRepository;
import dev.jmpalazzolo.springblog.services.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	
	private static final String USER_ROLE = "ROLE_USER";
	
	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Set<Role> roles = new HashSet<Role>();
		roles.add(roleRepository.findByRole(USER_ROLE));
		user.setRoles(roles);
		return userRepository.saveAndFlush(user);
	}
		
}
