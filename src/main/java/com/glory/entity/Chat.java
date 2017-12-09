package com.glory.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Monster on 2017/12/4.
 */
@Entity
@Table(name = "t_chat", schema = "glory", catalog = "")
public class Chat extends BaseEntity {
    private int id;
    private String content;
    private Timestamp createAt;
    private int userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "create_at")
    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chat tChat = (Chat) o;

        if (id != tChat.id) return false;
        if (userId != tChat.userId) return false;
        if (content != null ? !content.equals(tChat.content) : tChat.content != null) return false;
        if (createAt != null ? !createAt.equals(tChat.createAt) : tChat.createAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
