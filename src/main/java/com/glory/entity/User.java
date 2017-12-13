package com.glory.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_users", schema = "glory", catalog = "")
public class User {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "role_id")
    private int roleId;

    @Basic
    @Column(name = "group_id")
    private Integer groupId;

    @Basic
    @Column(name = "create_at")
    private Date createAt;

    @OneToMany(mappedBy = "articleByUser")
    private Collection<Article> userToArticle;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }


    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User tUsers = (User) o;
        return id == tUsers.id &&
                roleId == tUsers.roleId &&
                Objects.equals(email, tUsers.email) &&
                Objects.equals(password, tUsers.password) &&
                Objects.equals(name, tUsers.name) &&
                Objects.equals(groupId, tUsers.groupId) &&
                Objects.equals(createAt, tUsers.createAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, password, name, roleId, groupId, createAt);
    }


    public Collection<Article> getuserToArticle() {
        return userToArticle;
    }

    public void setuserToArticle(Collection<Article> userToArticle) {
        this.userToArticle = userToArticle;
    }
}
