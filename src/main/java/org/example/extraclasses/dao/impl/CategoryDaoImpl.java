package org.example.extraclasses.dao.impl;

import org.example.extraclasses.dao.CategoryDao;
import org.example.extraclasses.entity.CategoryInfo;
import org.example.extraclasses.util.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    Connection connection = null;
    List<CategoryInfo> categoryInfos = new ArrayList<>();

    @Override
    public List<CategoryInfo> findAll() {
        try {

            connection = Connector.getConnection();
            String sql = "select `id`, `name`,`discount`,`alias_name` from category";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            int offset = 0;
            while (resultSet.next()) {
                offset++;
                int id = resultSet.getInt("id");
                String name = resultSet.getString(2);
                int discount = resultSet.getInt("discount");
                String alias = resultSet.getString("alias_name");
                CategoryInfo info = new CategoryInfo (id, name, discount, alias);
                categoryInfos.add(info);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return categoryInfos;
    }
}
