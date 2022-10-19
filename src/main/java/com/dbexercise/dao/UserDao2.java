package com.dbexercise.dao;

import com.dbexercise.domain.User;

import java.sql.*;
import java.util.Map;

public class UserDao2 {


    public void add() throws SQLException, ClassNotFoundException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver"); // 자바와 MySQL의 통역관이라 생각하면 편함
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword); // DB와 연결 부분
        PreparedStatement ps = conn.prepareStatement(
                "insert into users(id, name, password) values(?, ?, ?)"
        );

//        ps.setString(1, "1");
//        ps.setString(2, "Kyeongrok");
//        ps.setString(3, "100203");

        ps.setString(1, "1");
        ps.setString(2, "Kyeongrok");
        ps.setString(3, "100203");

        ps.executeUpdate(); // ctrl + enter
        ps.close();         // 연결 끊기
        conn.close();

    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
        PreparedStatement ps = conn.prepareStatement("select * from users where id = ?");

        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));

        rs.close();
        ps.close();         // 연결 끊기
        conn.close();
        return user;
    }

    public void findALL() throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);

        Statement statement = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement("select * from users");
        ResultSet rs = ps.executeQuery();


        while(rs.next()) {
            System.out.printf("[id,name,password] : %s, %s, %s\n",
                    rs.getString("id"), rs.getString("name"), rs.getString("password"));
        }

        rs.close();
        ps.close();         // 연결 끊기
        conn.close();
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao2 userDao2 = new UserDao2();
//        userDao2.add();
        User user = userDao2.get("0");
        System.out.println(user.getName());
//        userDao2.findALL();
    }
}
