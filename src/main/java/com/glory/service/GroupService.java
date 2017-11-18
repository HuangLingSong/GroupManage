package com.glory.service;

import com.glory.entity.Group;

import java.util.List;

/**
 * Created by Monster on 2017/11/18.
 */
public interface GroupService {

    public List<Group> getGroup();

    public int create(Group group);

}
