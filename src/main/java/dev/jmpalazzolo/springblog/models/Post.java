package dev.jmpalazzolo.springblog.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Table(name = "posts")
@Data
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long id;
	
	@Column(name = "title", nullable = false)
	@Length(min = 5, message = "Your title must be at least 5 characters long")
	@NotEmpty(message = "Please introduce a title")
	private String title;
	
	@Column(name = "body", columnDefinition = "TEXT")
	private String body;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false, updatable = false)
	@CreationTimestamp
	private Date createDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	@NotNull
	private User user;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
	private Set<Comment> comments;
}
