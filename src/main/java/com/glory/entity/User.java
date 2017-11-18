package com.glory.entity;

/**
 * Created by Monster on 2017/10/25.
 */
public class User {

    private int id;

    private String username;

    private String eamil;

    private String password;

    private int roleId;

    private int groupId;

    private String createAt;

    public User() {
    }

    public User(String username, String eamil, String password) {
        this.username = username;
        this.eamil = eamil;
        this.password = password;
    }

    public User(int id, int roleId, int groupId) {
        this.id = id;
        this.roleId = roleId;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
