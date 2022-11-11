package com.CarRental.Dao;

import com.CarRental.bean.Car;
import com.CarRental.bean.User;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface Dao {
    User getUserById(String userId);
    int addUserdetails(String Name, String Email, int mobile,  String password,  String Cpassword) throws SQLException, ClassNotFoundException;
    List getCars(Date pdate, Date ddate, String model);

    List<Car> getcardetails(int id) throws ClassNotFoundException;

   List gethistory(int rid);
}
