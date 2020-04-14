package dev.jmpalazzolo.springblog.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "email", unique = true ,nullable = false)
	@Email(message = "Please provide a valid email")
	@NotEmpty(message = "Please provide an email")
	private String email;
	
	@Column(name = "username", unique = true, nullable = false)
	@Length(min = 8, max = 20, message = "Please provide an username between 8 and 20 characters")
	@NotEmpty(message = "Please provide an user name")
	private String username;
	
	@Column(name = "password", nullable = false)
	@Length(min = 8, max = 100, message = "Please provide a password between 8 and 20 characters")
	@NotEmpty(message = "Please provide a password")
	private String password;
	
	@Column(name = "active", nullable = false)
    private int active;
	
	@Column(name = "name", nullable = false)
	@NotEmpty(message = "Please provide a name")
	private String name;
	
	@Column(name = "last_name", nullable = false)
	@NotEmpty(message = "Please provide a last name")
	private String lastName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	@OneToMany(mappedBy = "user")
	private Set<Post> posts;
	
}
