package com.dbexercise.dao;

import com.dbexercise.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDaoAbstract {

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

    public void add(User user) {

        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into users(id,name,password) values (?,?,?)");

            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public User getById(String id) {

        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from users where id = ?");

            ps.setString(1,id);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            User user = new User(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("password"));

            resultSet.close();
            ps.close();
            conn.close();
            return user;

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao3 userDao3 = new UserDao3();
        userDao3.add(new User("7","RURU","1234QWER"));
        System.out.println(userDao3.getById("1"));

    }
}
