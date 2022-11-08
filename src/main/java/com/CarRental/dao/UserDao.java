package com.CarRental.dao;

import com.CarRental.Controller.bean.User;

import java.sql.SQLException;

public interface UserDao {
    User getUserById(String userId);
    int addUserdetails(String Name, String Email, int mobile,  String password,  String Cpassword) throws SQLException, ClassNotFoundException;
}
