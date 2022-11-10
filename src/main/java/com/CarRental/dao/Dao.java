package com.CarRental.dao;

import com.CarRental.Controller.bean.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface Dao {
    User getUserById(String userId);
    int addUserdetails(String Name, String Email, int mobile,  String password,  String Cpassword) throws SQLException, ClassNotFoundException;
    List getCars(LocalDate pdate, LocalDate ddate, String model);

    int getcardetails(int id) throws ClassNotFoundException;
}
