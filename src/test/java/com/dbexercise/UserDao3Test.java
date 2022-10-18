package com.dbexercise;

import com.dbexercise.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserDao3Test {

    @Test
    void addAndSelect() {

//        UserDao3 userDao = new UserDao3();
        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
        User user = new User("9", "EternityHwan", "1123");
        userDao.add(user);

        User selectedUser = userDao.getById("9");
        Assertions.assertEquals("EternityHwan",selectedUser.getName());
    }


}