package com.dbexercise;

import com.dbexercise.UserDaoAbstract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class AWSUserDaoImpl extends UserDaoAbstract {
    @Override
    public Connection getConnection() throws SQLException {
        Map<String, String> getenv = System.getenv();
        Connection conn = DriverManager.getConnection(getenv.get("DB_HOST"),
                getenv.get("DB_USER"), getenv.get("DB_PASSSWORD"));
        return conn;

    }
}
