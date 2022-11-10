package com.CarRental.dao;

import com.CarRental.Controller.bean.User;
import com.CarRental.Controller.bean.car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DaoImpl extends JdbcDaoSupport implements Dao {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {

        setDataSource(dataSource);
    }


    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public User getUserById(String userId) {
        String sql = "select pwd from register where email=? ";

        return getJdbcTemplate().queryForObject(sql, new Object[]{userId}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUser(userId);
                user.setPassword(rs.getString(1));
                return user;
            }
        });

    }

    public int addUserdetails(String Name, String Email, int mobile, String password, String Cpassword) throws ClassNotFoundException {

        String sql = "insert into register(name,email,mobile,pwd,cpwd) values(?,?,?,?,?) ";
        int res = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root", "123456")) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Name);
            ps.setString(2, Email);
            ps.setInt(3, mobile);
            ps.setString(4, password);
            ps.setString(5, Cpassword);
            res = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;


    }

//    public car getCars(String plocation, String dlocation, Date pdate) {
//        String sql = "select car_name from cardetails where pick_location='forum mall' and drop_location='airport,bangalore'";
//
//        return getJdbcTemplate().queryForObject(sql, new Object[]{plocation}, new RowMapper<car>() {
//
//            @Override
//            public car mapRow(ResultSet rs, int rowNum) throws SQLException {
//                car c = new car();
//                c.setPlocation(plocation);
//                c.setDlocation(dlocation);
//
//
//                return c;
//            }
//        });
//
//    }
    public List<car> getCars(LocalDate pdate, LocalDate ddate, String model)
    {

        String sql = "SELECT * FROM userdetails where pdate<=? and ddate>=? and model=? and status=0 order";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,pdate,ddate,model);
        List<car> c=new ArrayList<>();
        //System.out.println(list);
        for(Map<String,Object> map:list)
        {
            car cl=new car();
            cl.setCarname((String) map.get("model"));
            cl.setCost((Integer) map.get("car_cost"));
            cl.setSeats((Integer) map.get("car_seats"));
            cl.setId((Integer) map.get("id"));
            c.add(cl);
            System.out.println(cl.getCarname());
        }

//        new RowMapper<car>() {
//
//             @Override
//             public car mapRow(ResultSet rs, int rowNum) throws SQLException {
//                 car user = new car();
//                 user.setPlocation(plocation);
//                 user.setCarname(rs.getString(1));
//                 user.setCost(rs.getInt(2));
//                 user.setSeats(rs.getInt(3));
//
//                 return user;
//             }
//         });
//        System.out.println(c.get(1).getCost());
        return c;

    }

    public int getcardetails(int id) throws ClassNotFoundException {
        String sql = "UPDATE userdetails set status=1 where id=?";
        int res=0;
        jdbcTemplate.update(sql, id);
        return res;
    }

}
