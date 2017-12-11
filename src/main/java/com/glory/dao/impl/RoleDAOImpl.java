package com.glory.dao.impl;

import com.glory.dao.RoleDAO;
import com.glory.entity.Role;
import com.glory.libraries.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monster on 2017/11/18.
 */
public class RoleDAOImpl  implements RoleDAO {

    DBManager dbManager = null;

    public List<Role> getrole(){
        List<Role> list = new ArrayList<Role>();
        dbManager = new DBManager();
        try {
            String sql = "select *from t_roles";
            ResultSet resultSet = dbManager.doQurey(sql, null);
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setRole(resultSet.getString("role_name"));
                list.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.CloseConnection();
        }
        return list;
    }
}
