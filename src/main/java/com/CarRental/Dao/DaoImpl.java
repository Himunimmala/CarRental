package com.CarRental.Dao;

import com.CarRental.bean.User;
import com.CarRental.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
    public List<Car> getCars(Date pdate, Date ddate, String model)
    {
        String sql;
        System.out.println(model);
        List<Car> c=new ArrayList<>();
        if(model.equals("any"))
        {
             sql = "SELECT * FROM userdetails where pdate<=? and ddate>=?  and status=0 ";
             System.out.println(model);
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,pdate,ddate);


            //System.out.println(list);
            for(Map<String,Object> map:list)
            {
                Car cl=new Car();
                cl.setCarname((String) map.get("model"));
                cl.setCost((Integer) map.get("car_cost"));
                cl.setSeats((Integer) map.get("car_seats"));
                cl.setId((Integer) map.get("id"));
                c.add(cl);
                System.out.println(cl.getCarname());
            }
        }
        else {
            sql = "SELECT * FROM userdetails where pdate<=? and ddate>=?   and model=? and status=0 ";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,pdate,ddate,model);


            //System.out.println(list);
            for(Map<String,Object> map:list)
            {
                Car cl=new Car();
                cl.setCarname((String) map.get("model"));
                cl.setCost((Integer) map.get("car_cost"));
                cl.setSeats((Integer) map.get("car_seats"));
                cl.setId((Integer) map.get("id"));
                c.add(cl);
                System.out.println(cl.getCarname());
            }
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
        if(c.size()==0)
        {
            System.out.println("Sorry! no cars available");
        }
        return c;

    }

    public List<Car> gethistory(int rid)
    {
        String sql;

        List<Car> c=new ArrayList<>();

            sql = "SELECT id FROM bookdetails where regnum=? ";
      //  String query = "select name from employee where emp_id=?";
        Object[] inputs = new Object[] {rid};
        String empName = getJdbcTemplate().queryForObject(sql, inputs, String.class);
        System.out.println("details:"+empName);
        Integer number = Integer.valueOf(empName);
        sql = "SELECT * FROM userdetails where id=?";
        List<Map<String,Object>> list1 = jdbcTemplate.queryForList(sql,number);
        System.out.println("list1:"+list1);
        List<Car> c1=new ArrayList<>();
        //System.out.println(list);
        for(Map<String,Object> map:list1)
        {
            System.out.println("hii");
            Car cl=new Car();
            cl.setCarname((String) map.get("model"));
            cl.setCost((Integer) map.get("car_cost"));
            cl.setSeats((Integer) map.get("car_seats"));
            cl.setId((Integer) map.get("id"));
            cl.setPdate((Date) map.get("pdate"));
            cl.setDdate((Date) map.get("ddate"));
            c.add(cl);
            System.out.println(cl.getCarname());
        }



//        String a= jdbcTemplate.queryForObject(sql,rid);

//        List<Car> l=getJdbcTemplate().query(sql,new Object[]{rid},new ResultSetExtractor<List<Car>>(){
//
//            public List<Car> extractData(ResultSet rs) throws SQLException, DataAccessException {
//                List<Car> list = new ArrayList<Car>();
//                while (rs.next()) {
//                    Car student = new Car();
//                    student.setId(rs.getInt("id"));
//                    //student.setCompany(rs.getString("company"));
//                    System.out.println(student.getId());
//                    int a=student.getId();
//                    String sql4 = "SELECT * FROM userdetails where id=? ";
//                    List<Map<String,Object>> list1 = jdbcTemplate.queryForList(sql,a);
//
//
//                    //System.out.println(list);
//                    for(Map<String,Object> map:list1)
//                    {
//                        Car cl=new Car();
//                        cl.setCarname((String) map.get("model"));
//                        cl.setCost((Integer) map.get("car_cost"));
//                        cl.setSeats((Integer) map.get("car_seats"));
//                        cl.setPdate((Date) map.get("pdate"));
//                        cl.setDdate((Date) map.get("ddate"));
//                        cl.setId((Integer) map.get("id"));
//                        list.add(cl);
//                        System.out.println(cl.getCarname());
//                    }
//
//                }
//
//                return list;
//            }
//        });



        //System.out.println(list);
//            for(Map<String,Object> map:list)
//            {
//                Car cl=new Car();
//                cl.setCarname((String) map.get("model"));
//                cl.setCost((Integer) map.get("car_cost"));
//                cl.setSeats((Integer) map.get("car_seats"));
//                cl.setId((Integer) map.get("id"));
//                c.add(cl);
//                System.out.println(cl.getCarname());
//            }

     return c;

    }

    public List<Car> getcardetails(int id)
    {
        String sql2 = "UPDATE userdetails set status=1 where id=?";
        Random random = new Random();

        int regnum = random.nextInt(50);

        String sql3 = " insert into  bookdetails (regnum,id) values(?,?)";


        int res = 0;
        jdbcTemplate.update(sql2, id);
        jdbcTemplate.update(sql3, regnum, id);

        String sql5 = "SELECT * FROM bookdetails where id=? ";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql5, id);
        List<Car> c = new ArrayList<>();

        System.out.println("list"+list);
        for (Map<String, Object> map : list) {
            Car cl = new Car();

            cl.setRegnum((Integer) map.get("regnum"));
            c.add(cl);

        }
        return c;
    }


}
