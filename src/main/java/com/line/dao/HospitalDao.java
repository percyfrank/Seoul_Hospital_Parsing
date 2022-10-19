package com.line.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class HospitalDao {
    public void add() throws SQLException, ClassNotFoundException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver"); // 자바와 MySQL의 통역관이라 생각하면 편함
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword); // DB와 연결 부분
        PreparedStatement ps = conn.prepareStatement(
                "insert into (id, address, district,category,emergencyRoom,name,subdivision) " +
                        "values(?, ?, ?, ?, ?, ?, ?)"
        );

        ps.setString(1, "1");
        ps.setString(2, "Kyeongrok");
        ps.setString(3, "100203");

        ps.executeUpdate(); // ctrl + enter
        ps.close();         // 연결 끊기
        conn.close();

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        HospitalDao hospitalDao = new HospitalDao();
        hospitalDao.add();

    }

}
