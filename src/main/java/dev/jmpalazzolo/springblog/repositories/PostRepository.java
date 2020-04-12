package dev.jmpalazzolo.springblog.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import dev.jmpalazzolo.springblog.models.Post;
import dev.jmpalazzolo.springblog.models.User;

public interface PostRepository extends PagingAndSortingRepository<Post, Long>{

	Page<Post> findByUserOrderByCreateDateDesc(User user, Pageable pageable);

    Page<Post> findAllByOrderByCreateDateDesc(Pageable pageable);

    Optional<Post> findById(Long id);
}
