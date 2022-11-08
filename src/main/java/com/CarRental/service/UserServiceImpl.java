package com.CarRental.service;

import com.CarRental.Controller.bean.User;
import com.CarRental.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public User getUserByUserId(String userId){
        User user=userDao.getUserById(userId);
        return user;
    }
    public int addUser(String Name, String Email, int mobile,  String password,  String Cpassword) throws SQLException, ClassNotFoundException {
        int user1=userDao.addUserdetails(Name,Email,mobile, password,Cpassword);
        return user1;
    }
}
