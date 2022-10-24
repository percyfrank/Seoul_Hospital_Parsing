package com.dbexercise2.dao;

import com.dbexercise2.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void jdbcContextWithStatementStrategy(StatementStrategy stmt) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
//            conn = connectionMaker.makeConnection();
            conn = dataSource.getConnection();
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

    public void add(User user) {
        jdbcContextWithStatementStrategy(new AddStrategy(user));
    }

    public User findById(String id) {

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from users where id = ?");

            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();

            User user = null;
            if(rs.next()) {
                user = new User(rs.getString("id"),
                        rs.getString("name"), rs.getString("password"));
            }

            if(user == null) throw new EmptyResultDataAccessException("데이터가 없습니다",1);
            rs.close();
            ps.close();
            conn.close();

            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAll() {
        jdbcContextWithStatementStrategy(new DeleteAllStrategy());
    }

    public int getCount() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
//            conn = connectionMaker.makeConnection();
            conn = dataSource.getConnection();
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

    public static void main(String[] args) {

    }
}
