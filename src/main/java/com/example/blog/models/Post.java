package com.example.blog.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

    @Id @GeneratedValue
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @NotBlank(message = "Posts must have a title")
    @Size(min = 3, message = "A title must be at least 3 characters.")
    @Column(nullable = false, length = 200)
    private String title;

    @NotBlank(message = "Posts must have content")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;

    //Creates the relationship to the users table
    @OneToOne
    private User user;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
    private List<PostImage> images;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
    private List<Comment> comments;

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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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



    public Post(String title, String body, long id, User user, List<PostImage> images, List<Categories> categories, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.images = images;
        this.categories = categories;
        this.comments = comments;
    }

    public Post(String title, String body, User user, List<PostImage> images, List<Categories> categories, List<Comment> comments) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.images = images;
        this.categories = categories;
        this.comments = comments;
    }

    public Post(String title, String body, User user, List<Categories> categories) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.categories = categories;
    }


    public Post(String title, String body, User user, List<Categories> categories, Date createDate) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.categories = categories;
        this.createDate = createDate;
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
