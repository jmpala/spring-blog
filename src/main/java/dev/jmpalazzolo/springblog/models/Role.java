package dev.jmpalazzolo.springblog.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "role")
@Data
@EqualsAndHashCode(exclude = "users")
@ToString(exclude = "users")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long id;
	
	@Column(name = "role", unique = true)
	private String role;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
	private Set<User> users;
}
