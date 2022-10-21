package com.dbexercise.dao;

import com.dbexercise.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.*;
import java.util.Map;

public class UserDao3 {

    private ConnectionMaker connectionMaker;

    public UserDao3() {
        connectionMaker = new AWSConnectionMaker();
    }

    public UserDao3(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void jdbcContextWithStatementStrategy(StatementStrategy stmt) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = connectionMaker.getConnection();
            ps = stmt.makePreparedStatement(conn);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
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
        jdbcContextWithStatementStrategy(new AddStrategy(user));
    }

    public User getById(String id) {

        try {
            Connection conn = connectionMaker.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from users where id = ?");

            ps.setString(1,id);
            ResultSet resultSet = ps.executeQuery();

            User user = null;
            if(resultSet.next()) {
                user = new User(resultSet.getString("id"),
                        resultSet.getString("name"), resultSet.getString("password"));
            }

            resultSet.close();
            ps.close();
            conn.close();

            if(user == null) throw new EmptyResultDataAccessException(1);

            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAll()  {
        jdbcContextWithStatementStrategy(new DeleteAllStrategy());
    }

    public int getCount() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectionMaker.getConnection();
            ps = conn.prepareStatement("select count(*) from users");
            rs = ps.executeQuery();
            rs.next();

            int count = rs.getInt(1);
            return count;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao3 userDao3 = new UserDao3();
        userDao3.add(new User("7","RURU","1234QWER"));
        System.out.println(userDao3.getById("1"));

    }
}
