package com.codegym.service.comment;

import com.codegym.exception.HasForbiddenWordsException;
import com.codegym.model.Blog;
import com.codegym.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CommentService {
    Page<Comment> findAll(Pageable pageable);

    Optional<Comment> findById(Long id);

    void save(Comment comment) throws HasForbiddenWordsException;

    void deleteById(Long id);

    Page<Comment> findAllByBlog(Blog blog, Pageable pageable);
}
