package com.CarRental.Service;

import com.CarRental.bean.Car;
import com.CarRental.bean.User;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface Service {
    User getUserByUserId(String userId);
    int addUser(String Name, String Email,  String password,  String Cpassword) throws SQLException, ClassNotFoundException;

    List getcardetails(Date pdate, Date ddate, String model);
    List<Car> getusercardetails(int id) throws ClassNotFoundException;
   List gethistorydetails(int id);
    List getreturn(int id);


}
