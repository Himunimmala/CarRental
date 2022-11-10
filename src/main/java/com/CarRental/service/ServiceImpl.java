package com.CarRental.service;

import com.CarRental.Controller.bean.User;
import com.CarRental.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    Dao userDao;

    @Override
    public User getUserByUserId(String userId){
        User user=userDao.getUserById(userId);
        return user;
    }
    public int addUser(String Name, String Email, int mobile,  String password,  String Cpassword) throws SQLException, ClassNotFoundException {
        int user1=userDao.addUserdetails(Name,Email,mobile, password,Cpassword);
        return user1;
    }
    public List getcardetails(LocalDate pdate, LocalDate ddate, String model){
        List user=userDao.getCars( pdate,ddate,model);
        return user;
    }
    public int getusercardetails(int id) throws ClassNotFoundException {
        int user=userDao.getcardetails(id);
        return user;
    }
}
