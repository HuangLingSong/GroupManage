package com.glory.service.impl;

import com.glory.dao.RoleDAO;
import com.glory.dao.impl.RoleDAOImpl;
import com.glory.entity.Role;
import com.glory.service.RoleService;

import java.util.List;

/**
 * Created by Monster on 2017/11/18.
 */
public class RoleServiceImpl implements RoleService{

    private RoleDAO roleDAO =  new RoleDAOImpl();

    public List<Role> getrole(){
        return roleDAO.getrole();
    }

}
