package dev.jmpalazzolo.springblog.services;

import java.util.Optional;

import org.springframework.data.domain.Page;

import dev.jmpalazzolo.springblog.models.Post;
import dev.jmpalazzolo.springblog.models.User;


public interface PostService {

	Optional<Post> findForId(Long id);

    Post save(Post post);

    Page<Post> findByUserOrderedByDatePageable(User user, int page);

    Page<Post> findAllOrderedByDatePageable(int page);

    void delete(Post post);
}
