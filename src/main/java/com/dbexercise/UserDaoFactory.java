package com.dbexercise;

public class UserDaoFactory {

    public UserDao3 awsUserDao() {
        AWSConnectionMaker awsConnectionMaker = new AWSConnectionMaker();
        UserDao3 userDao = new UserDao3(awsConnectionMaker);
        return userDao;
    }

//    public UserDao3 localUserDao() {
//        UserDao3 userDao = new UserDao3(new LocalConnectionMaker());
//        return userDao;
//    }

}
