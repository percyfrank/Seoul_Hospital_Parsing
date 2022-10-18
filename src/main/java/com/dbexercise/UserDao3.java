package com.dbexercise;

import com.dbexercise.domain.User;

import java.sql.*;
import java.util.Map;

public class UserDao3 {

    private ConnectionMaker awsConnectionMaker;

    public UserDao3() {
        this.awsConnectionMaker = awsConnectionMaker;
    }

    //    private Connection getConnection() throws SQLException, ClassNotFoundException {
//        Map<String, String> getenv = System.getenv();
//        String dbHost = getenv.get("DB_HOST");
//        String dbUser = getenv.get("DB_USER");
//        String dbPassword = getenv.get("DB_PASSWORD");
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
//        return conn;
//    }

    public void add(User user) {

        try {
            awsConnectionMaker = new AWSConnectionMaker();
            Connection conn = awsConnectionMaker.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into users(id,name,password) values (?,?,?)");

            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public User getById(String id) {

        try {
            awsConnectionMaker = new AWSConnectionMaker();
            Connection conn = awsConnectionMaker.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from users where id = ?");

            ps.setString(1,id);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            User user = new User(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("password"));

            resultSet.close();
            ps.close();
            conn.close();
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao3 userDao3 = new UserDao3();
        userDao3.add(new User("7","RURU","1234QWER"));
        System.out.println(userDao3.getById("1"));

    }
}
