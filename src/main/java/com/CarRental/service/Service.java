package com.CarRental.service;

import com.CarRental.Controller.bean.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface Service {
    User getUserByUserId(String userId);
    int addUser(String Name, String Email, int mobile,  String password,  String Cpassword) throws SQLException, ClassNotFoundException;

    List getcardetails(LocalDate pdate, LocalDate ddate, String model);
    int getusercardetails(int id) throws ClassNotFoundException;
}
