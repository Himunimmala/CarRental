package com.CarRental.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.CarRental.Controller.bean.User;
import com.CarRental.dao.UserDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public User getUserById(String userId) {
        String sql="select user_pwd from login where user_id=? ";

        return getJdbcTemplate().queryForObject(sql,new Object[] {userId},new RowMapper<User>(){

            @Override
            public  User mapRow(ResultSet rs,int rowNum) throws SQLException{
                User user=new User();
                user.setUser(userId);
                user.setPassword(rs.getString(1));
                return user;
            }
        });

    }
    public int addUserdetails(String Name, String Email, int mobile,  String password,  String Cpassword) throws ClassNotFoundException {

            String sql="insert into register(name,email,mobile,pwd,cpwd) values(?,?,?,?,?) ";
            int res=0;
            Class.forName("com.mysql.jdbc.Driver");
            try(Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/demo","root","123456")) {
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,Name);
                ps.setString(2,Email);
                ps.setInt(3, mobile);
                ps.setString(4,password);
                ps.setString(5,Cpassword);
                res=ps.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return res;


    }
}
