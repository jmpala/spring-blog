package dev.jmpalazzolo.springblog.servicesimpl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import dev.jmpalazzolo.springblog.models.Post;
import dev.jmpalazzolo.springblog.models.User;
import dev.jmpalazzolo.springblog.repositories.PostRepository;
import dev.jmpalazzolo.springblog.services.PostService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {

	private final PostRepository postRepository;

	@Override
	public Optional<Post> findForId(Long id) {
		return postRepository.findById(id);
	}

	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Page<Post> findByUserOrderedByDatePageable(User user, int page) {
		return postRepository.findByUserOrderByCreateDateDesc(user, PageRequest.of(substractPageByOne(page), 5));
	}

	@Override
	public Page<Post> findAllOrderedByDatePageable(int page) {
		return postRepository.findAll(PageRequest.of(substractPageByOne(page), 5));
	}

	@Override
	public void delete(Post post) {
		postRepository.delete(post);
	}
	
	private int substractPageByOne(int page) {
		return (page < 1) ? 0 : page - 1;
	}
}
