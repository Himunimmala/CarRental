package com.CarRental.Controller;

import com.CarRental.Controller.bean.User;
import com.CarRental.Controller.bean.car;
import com.CarRental.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLException;
import java.time.LocalDate;
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
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/final", method = RequestMethod.GET)
    public String finalone() {
        return "final";
    }
    @RequestMapping(value = "/last", method = RequestMethod.POST)
    public String next(@RequestParam int id) throws ClassNotFoundException {
        System.out.println("working");
        int a= service.getusercardetails(id);
//        ModelAndView model1 = new ModelAndView();
//        model1.addObject("personsList", a);
//
//        model1.setViewName("last");
        return "redirect:final";
    }

    @RequestMapping(value = "/userloginpage", method = RequestMethod.POST)
    public ModelAndView cardetailspage(@RequestParam String pdate,@RequestParam String ddate,@RequestParam String model) {
//        ModelAndView model1 = new ModelAndView();

        ModelAndView model1 = new ModelAndView(new RedirectView("index"));

        LocalDate start=LocalDate.parse(pdate);
        LocalDate end=LocalDate.parse(ddate);
        List<car> user=  service.getcardetails(start,end, model);
//        car c1= new car();
//        c1.setCarname("test");
//        c1.setCost(100);
//        user.add(c1);
        //       for(int i=0;i<user.size();i++)
//          System.out.println(user.get(i).getCost());
        model1.addObject("personsList", user);

        model1.setViewName("index");


       return model1;
    }
}


