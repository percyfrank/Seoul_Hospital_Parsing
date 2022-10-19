package com.dbexercise;

import com.dbexercise.dao.UserDao3;
import com.dbexercise.dao.UserDaoFactory;
import com.dbexercise.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDao3Test {

    @Autowired
    ApplicationContext context;
    @Test
    void addAndSelect() {

//        UserDao3 userDao = new UserDao3(new AWSConnectionMaker());
//        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
//        UserDao3 userDao = new UserDaoFactory().awsUserDao();
        UserDao3 userDao = context.getBean("awsUserDao", UserDao3.class);
        User user = new User("16", "EternityHwan", "1123");
        userDao.add(user);

        User selectedUser = userDao.getById("16");
        Assertions.assertEquals("EternityHwan",selectedUser.getName());
    }
}