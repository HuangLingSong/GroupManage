package com.glory.service.impl;

import com.glory.dao.GroupDAO;
import com.glory.dao.impl.GroupDAOImpl;
import com.glory.entity.Group;
import com.glory.service.GroupService;

import java.util.List;

/**
 * Created by Monster on 2017/11/18.
 */
public class GroupServiceImpl implements GroupService {

    private GroupDAO  groupDAO = new GroupDAOImpl();

    public List<Group> getGroup(){
        return groupDAO.getGroup();
    }
}
