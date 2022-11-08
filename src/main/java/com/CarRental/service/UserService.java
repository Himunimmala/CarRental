package com.CarRental.service;

import com.CarRental.Controller.bean.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

public interface UserService {
    User getUserByUserId(String userId);
    int addUser(String Name, String Email, int mobile,  String password,  String Cpassword) throws SQLException, ClassNotFoundException;
}
