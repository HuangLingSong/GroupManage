package com.glory.dao.impl;

import com.glory.dao.GroupDAO;
import com.glory.entity.Group;
import com.glory.libraries.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monster on 2017/11/18.
 */
public class GroupDAOImpl implements GroupDAO {

    DBManager dbManager = null;

    public List<Group> getGroup() {
        List<Group> list = new ArrayList<Group>();
        dbManager = new DBManager();
        try {
            String sql = "select *from t_groups";
            ResultSet resultSet = dbManager.doQurey(sql, null);
            while (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                group.setGroup(resultSet.getString("group"));
                list.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.CloseConnection();
        }
        return list;
    }
}
