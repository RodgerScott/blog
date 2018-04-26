package com.example.blog.repositories;

import com.example.blog.models.Comment;
import com.example.blog.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    public List<Comment> findById(Long id);

}
