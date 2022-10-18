package com.dbexercise;

import com.dbexercise.domain.User;

import java.sql.*;
import java.util.Map;

public class UserDao3 {

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Map<String, String> getenv = System.getenv();
        String dbHost = getenv.get("DB_HOST");
        String dbUser = getenv.get("DB_USER");
        String dbPassword = getenv.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
        return conn;
    }

    public void add() throws ClassNotFoundException, SQLException {


        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into users(id,name,password) values (?,?,?)");

            ps.setString(1, "1");
            ps.setString(2, "Kyeongrok");
            ps.setString(3, "100203");

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
        userDao3.add();
        System.out.println(userDao3.getById("1"));

    }
}
