package com.dbexercise2.dao;

import com.dbexercise2.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {


    @Autowired
    ApplicationContext context;

    private UserDao userDao;

    private User user1,user2,user3;

    @BeforeEach
    void setUp() {
        this.userDao = this.context.getBean("awsUserDao", UserDao.class);
        this.user1 = new User("1", "권오석", "1234");
        this.user2 = new User("2", "권오석1", "12345");
        this.user3 = new User("3", "권오석2", "123456");
    }


    @Test
    public void addAndGet() throws Exception {
        //when
        userDao.deleteAll();
        //then
        assertThat(userDao.getCount()).isEqualTo(0);

        userDao.add(user1);
        assertThat(userDao.getCount()).isEqualTo(1);

        User byId = userDao.findById(user1.getId());
        assertThat(byId.getName()).isEqualTo(user1.getName());
        assertThat(byId.getPassword()).isEqualTo(user1.getPassword());

    }

    @Test
    public void findById() throws Exception {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            userDao.findById("40");
        });
    }

    @Test
    public void count() throws Exception {
        //given
        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);
        userDao.add(user1);
        assertThat(userDao.getCount()).isEqualTo(1);
        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);
        userDao.add(user3);
        assertThat(userDao.getCount()).isEqualTo(3);
        //when

        //then
    }










}