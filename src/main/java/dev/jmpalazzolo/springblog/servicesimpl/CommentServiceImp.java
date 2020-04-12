package dev.jmpalazzolo.springblog.servicesimpl;

import org.springframework.stereotype.Service;

import dev.jmpalazzolo.springblog.models.Comment;
import dev.jmpalazzolo.springblog.repositories.CommentRepository;
import dev.jmpalazzolo.springblog.services.CommentService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImp implements CommentService{

	private final CommentRepository commentRepository;
	
	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public void delete(Comment comment) {
		commentRepository.delete(comment);
	}

}
