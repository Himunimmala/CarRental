package com.CarRental.Service;

import com.CarRental.bean.Car;
import com.CarRental.bean.User;
import com.CarRental.Dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.SQLException;
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
    public int addUser(String Name, String Email,  String password,  String Cpassword) throws SQLException, ClassNotFoundException {
        int user1=userDao.addUserdetails(Name,Email, password,Cpassword);
        return user1;
    }
    public List getcardetails(Date pdate, Date ddate, String model){
        List user=userDao.getCars( pdate,ddate,model);
        return user;
    }
    public List<Car> getusercardetails(int id) throws ClassNotFoundException {
        List user=userDao.getcardetails(id);
        return user;
    }
    public List gethistorydetails(int rid)
    {
        List u=userDao.gethistory(rid);
        return u;
    }
    public List getreturn(int rid)
    {
        List u=userDao.returnf(rid);
        return u;
    }
}
