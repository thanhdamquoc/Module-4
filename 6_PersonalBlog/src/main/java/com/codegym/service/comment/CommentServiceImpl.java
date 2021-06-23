package com.codegym.service.comment;

import com.codegym.exception.HasForbiddenWordsException;
import com.codegym.model.Blog;
import com.codegym.model.Comment;
import com.codegym.model.ForbiddenWord;
import com.codegym.repository.CommentRepository;
import com.codegym.repository.ForbiddenWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ForbiddenWordRepository forbiddenWordRepository;

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) throws HasForbiddenWordsException{
        if (hasForbiddenWords(comment.getContent())) {
            throw new HasForbiddenWordsException();
        }
        commentRepository.save(comment);
    }

    private boolean hasForbiddenWords(String string) {
        String[] words = string.split(" ");
        Iterable<ForbiddenWord> forbiddenWords = forbiddenWordRepository.findAll();
        for (String word : words) {
            for (ForbiddenWord forbiddenWord : forbiddenWords) {
                if (word.equals(forbiddenWord.getWord())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Page<Comment> findAllByBlog(Blog blog, Pageable pageable) {
        return commentRepository.findAllByBlog(blog, pageable);
    }
}
