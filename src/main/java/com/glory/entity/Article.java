package com.glory.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_article", schema = "glory")
public class Article {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "create_at")
    private Timestamp createAt;

//    @Basic
//    @Column(name = "user_id")
//    private Integer userId;

    @Basic
    @Column(name = "role_id")
    private int roleId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User articleByUser;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public User getarticleByUser() {
        return articleByUser;
    }

    public void setarticleByUser(User articleByUser) {
        this.articleByUser = articleByUser;
    }



}
