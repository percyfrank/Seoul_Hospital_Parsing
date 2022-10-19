package com.dbexercise;

import com.dbexercise.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserDao3Test {

    @Test
    void addAndSelect() {

//        UserDao3 userDao = new UserDao3(new AWSConnectionMaker());
//        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
        UserDao3 userDao = new UserDaoFactory().awsUserDao();
        User user = new User("15", "EternityHwan", "1123");
        userDao.add(user);

        User selectedUser = userDao.getById("15");
        Assertions.assertEquals("EternityHwan",selectedUser.getName());
    }
}