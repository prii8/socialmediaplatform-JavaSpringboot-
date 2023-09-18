package com.hus23.assignment.socialmediaplatform.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name="comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentid;

    @Column(name="comment")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Post post;

    public Long getCommentid() {
        return commentid;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setCommentid(Long commentid) {
        this.commentid = commentid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentid=" + commentid +
                ", comment='" + comment + '\'' +
                '}';
    }
}
