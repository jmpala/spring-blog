package dev.jmpalazzolo.springblog.repositories;

import org.springframework.data.repository.CrudRepository;

import dev.jmpalazzolo.springblog.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
