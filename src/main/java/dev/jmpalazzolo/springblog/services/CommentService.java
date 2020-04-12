package dev.jmpalazzolo.springblog.services;

import dev.jmpalazzolo.springblog.models.Comment;

public interface CommentService {

	Comment save(Comment comment);
	
	void delete(Comment comment);
}
