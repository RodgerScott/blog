package com.example.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

    @Id @GeneratedValue
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    //Creates the relationship to users table
    @OneToOne
    private User user;

    @OneToOne
    private PostDetails postDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="posts_categories",
            joinColumns = {@JoinColumn(name="post_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")}
    )
    private List<Categories> categories;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post(String title, String body, long id, User user, PostDetails post, List<PostImage> images, List<Categories> categories) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.postDetails = post;
        this.images = images;
        this.categories = categories;
    }

    public Post(String title, String body, User user, PostDetails post, List<PostImage> images, List<Categories> categories) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.postDetails = post;
        this.images = images;
        this.categories = categories;
    }

    public Post(String title, String body, User user, List<Categories> categories) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.categories = categories;
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(User user) {
        this.user = user;
    }



    public Post() {
    }


}
