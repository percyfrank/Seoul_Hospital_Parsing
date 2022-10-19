package com.dbexercise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public void add() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://ec2-15-164-207-215.ap-northeast-2.compute.amazonaws.com/likelion-db",
                "root",
                "osoh140109@!"
        );

        PreparedStatement ps = conn.prepareStatement(
                "insert into users(id, name, password) values(?, ?, ?)"
        );

        ps.setString(1, "0");
        ps.setString(2, "Kyeongrok");
        ps.setString(3, "password");

        int status = ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        userDao.add();
    }
}
