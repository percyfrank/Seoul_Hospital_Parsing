package com.dbexercise2.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class UserDaoFactory {

    @Bean
    public UserDao awsUserDao() {
        return new UserDao(awsDataSource());

    }

    @Bean
    public UserDao localUserDao() {
        return new UserDao(localDataSource());
    }

    @Bean
    public DataSource awsDataSource() {
        Map<String, String> getenv = System.getenv();
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl(getenv.get("DB_HOST"));
        dataSource.setUsername(getenv.get("DB_USER"));
        dataSource.setPassword(getenv.get("DB_PASSWORD"));
        return dataSource;
    }

    @Bean
    public DataSource localDataSource() {
        Map<String, String> getenv = System.getenv();
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3306/like_lion");
        dataSource.setUsername("root");
        dataSource.setPassword("osoh140109@!");
        return dataSource;
    }
}
