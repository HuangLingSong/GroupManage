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
            String sql = "select t_groups.*,t_users.name as 'leader_name' from t_groups LEFT JOIN t_users on t_groups.leader=t_users.id";
            ResultSet resultSet = dbManager.doQurey(sql, null);
            while (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                group.setGroup(resultSet.getString("group"));
                group.setLeader(resultSet.getString("leader_name"));
                group.setCreateAt(resultSet.getString("create_at"));
                list.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.CloseConnection();
        }
        return list;
    }

    public int create(Group group){
        dbManager = new DBManager();
        int resultSet = 0;
        try {
            String sql = "insert into t_groups (group,leader,create_at) value (?,?,now())";
            resultSet = dbManager.doUpdate(sql, new Object[]{group.getGroup(),group.getLeaderId()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbManager.CloseConnection();
        }
        return resultSet;
    }

}
