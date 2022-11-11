package com.CarRental.Controller;

import com.CarRental.bean.User;
import com.CarRental.bean.Car;
import com.CarRental.Service.Service;
import com.CarRental.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    Service service;

    @RequestMapping(value = "/Welcome", method = RequestMethod.GET)
    public String Welcome() {
        return "Welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String UserLoginPage(ModelMap model, @RequestParam String userId, @RequestParam String password) {
        User user= service.getUserByUserId(userId);
        if(user.getPassword().equals(password)){
            model.put("userId",userId);
            return "redirect:userloginpage";
        }
        model.put("Msg","Enter the details properly");
        return "login";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String Register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String RegisterPage(ModelMap model, @RequestParam String Name, @RequestParam String Email,@RequestParam int mobile,@RequestParam String password,@RequestParam String Cpassword) throws SQLException, ClassNotFoundException {
//        if(password !=Cpassword)
//        {
//            System.out.println("no");
//            model.put("Msg", "Passwords should be same");
//            return "register";
//        }
//        if(!Email.contains("@"))
//        {
//            model.put("Msg","Enter mail properly");
//            return "register";
//        }
        int user= service.addUser(Name, Email,mobile,password,   Cpassword);
//        if(user.getPassword().equals(password)){
//            model.put("userId",userId);
//            return "userloginpage";
//        }
//        model.put("Msg","Successfull");
        return "redirect:login";
    }


    @RequestMapping(value = "/userloginpage", method = RequestMethod.GET)
    public String userloginpage() {
        return "userloginpage";
    }
    @RequestMapping(value = "/last", method = RequestMethod.GET)
    public String lastpage() {
        return "last";
    }
    @RequestMapping(value = "/errorpage", method = RequestMethod.GET)
    public String epage() {
        return "errorpage";
    }
    @RequestMapping(value = "/cardetails", method = RequestMethod.GET)
    public String index() {
        return "cardetails";
    }

    @RequestMapping(value = "/cardetails", method = RequestMethod.POST)
    public String index2() {
        return "cardetails";
    }
    @RequestMapping(value = "/History", method = RequestMethod.GET)
    public String history() {
        return "History";
    }
    @RequestMapping(value = "/Historydetails", method = RequestMethod.GET)
    public String historydetails() {
        return "Historydetails";
    }
    @RequestMapping(value = "/final", method = RequestMethod.GET)
    public String finalone() {
//        List<Car> u=service.getreservationnmber();
//        ModelAndView model1 = new ModelAndView();
//        model1.addObject("personsList", u);
//        model1.setViewName("cardetails");
//        return model1;

        return "final";
    }
    @RequestMapping(value = "/last", method = RequestMethod.POST)
    public ModelAndView next(@RequestParam int id) throws ClassNotFoundException {
        System.out.println("working");
        List<Car> a= service.getusercardetails(id);
        ModelAndView model1 = new ModelAndView();
        model1.addObject("regnum", a);

        model1.setViewName("final");
//        return "redirect:final";
        return model1;
    }
    @RequestMapping(value = "/History", method = RequestMethod.POST)
    public ModelAndView historydetails(@RequestParam int id) throws ClassNotFoundException {
        System.out.println("working for history");
        List<Car> a= service.gethistorydetails(id);
        System.out.println("list:"+a);
        ModelAndView model1 = new ModelAndView();
        if(a.size()==0)
        {
            model1.addObject("personsList",a);
            model1.setViewName("errorpage");
            return model1;
        }
        model1.addObject("regnum", a);

        model1.setViewName("Historydetails");
//        return "redirect:final";
        return model1;
    }

    @RequestMapping( value = "/userloginpage", method = RequestMethod.POST)
    public ModelAndView cardetailspage(@RequestParam Date pdate, @RequestParam Date ddate, @RequestParam String model) {
//        ModelAndView model1 = new ModelAndView();

        ModelAndView model1 = new ModelAndView();
//
//        LocalDate start=LocalDate.parse(pdate);
//        LocalDate end=LocalDate.parse(ddate);
        List<Car> user=  service.getcardetails(pdate,ddate, model);
        if(user.size()==0)
        {
            model1.addObject("personsList", user);
            model1.setViewName("errorpage");
            return model1;
        }

//        car c1= new car();
//        c1.setCarname("test");
//        c1.setCost(100);
//        user.add(c1);
        //for(int i=0;i<user.size();i++)
//          System.out.println(user.get(i).getCost());
        model1.addObject("personsList", user);
        model1.setViewName("cardetails");
       return model1;
    }
}


