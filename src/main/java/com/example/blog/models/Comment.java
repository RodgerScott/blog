package com.example.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post_comments")
public class Comment {

    @Column(nullable = false)
    private String commentBody;

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment(String commentBody, long id) {
        this.commentBody = commentBody;
        this.id = id;
    }

    public Comment(String commentBody) {
        this.commentBody = commentBody;
    }

    public Comment() {
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
