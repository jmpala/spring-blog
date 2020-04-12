package dev.jmpalazzolo.springblog.repositories;

import org.springframework.data.repository.CrudRepository;

import dev.jmpalazzolo.springblog.models.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

}
