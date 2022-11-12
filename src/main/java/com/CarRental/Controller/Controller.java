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


    /*
     * FIRST PAGE-Welcome
     * The GET mapping gives the welcome page with signup and signin
     * The user can either signup or signin
     */
    @RequestMapping(value = "/Welcome", method = RequestMethod.GET)
    public String Welcome() {
        return "Welcome";
    }
    /*
      * Signin page get mapping helps to give the login page details.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
    /*
     * Signin page post mapping helps to submit the username and password to database and validates it
     * Whether the user is already present or not/
     */
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
    /*
     * Signup page get mapping helps to give the register page details.
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String Register() {
        return "register";
    }
    /*
     * Signup page post mapping helps to submit the details of user to database
     * and redirects to login page
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String RegisterPage(ModelMap model, @RequestParam String Name, @RequestParam String Email,@RequestParam String password,@RequestParam String Cpassword) throws SQLException, ClassNotFoundException {
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
        int user= service.addUser(Name, Email,password,   Cpassword);

        return "redirect:login";
    }

    /*
      * User login page get mapping gives the details that need to be entered by the user.
      * pickup date,dropoff date,model
     */
    @RequestMapping(value = "/userloginpage", method = RequestMethod.GET)
    public String userloginpage() {
        return "userloginpage";
    }
    /*
     * User login page post mapping submits the details that are entered by the user.
     * pickup date,dropoff date,model
     * returns to the cardetails page as modelview(only viewing the details)
     *
     */
    @RequestMapping( value = "/userloginpage", method = RequestMethod.POST)
    public ModelAndView cardetailspage(@RequestParam Date pdate, @RequestParam Date ddate, @RequestParam String model) {
        ModelAndView model1 = new ModelAndView();

        List<Car> user=  service.getcardetails(pdate,ddate, model);
        if(user.size()==0)
        {
            model1.addObject("personsList", user);
            model1.setViewName("errorpage");
            return model1;
        }
        model1.addObject("cardetails", user);
        model1.setViewName("cardetails");
        return model1;
    }

    /*
     * last get mapping gives the id to be selected from previous car details table.
     * id
     */
    @RequestMapping(value = "/last", method = RequestMethod.GET)
    public String lastpage() {
        return "last";
    }
    /*
     * last page post mapping takes the id from user
     * generates the Reservation number
     *  updates the status
     */
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

    @RequestMapping(value = "/cardetails", method = RequestMethod.GET)
    public String index() {
        return "cardetails";
    }

    @RequestMapping(value = "/cardetails", method = RequestMethod.POST)
    public String index2() {
        return "cardetails";
    }

    @RequestMapping(value = "/final", method = RequestMethod.GET)
    public String finalone() {

        return "final";
    }




    @RequestMapping(value = "/History", method = RequestMethod.GET)
    public String history() {
        return "History";
    }

    @RequestMapping(value = "/History", method = RequestMethod.POST)
    public ModelAndView historydetails(@RequestParam int id) throws ClassNotFoundException {
        System.out.println("working for history");
        List<Car> a= service.gethistorydetails(id);
        System.out.println("list:"+a);
        ModelAndView model1 = new ModelAndView();
        if(a.size()==0)
        {
//            model1.addObject("cardetails",a);
            model1.setViewName("errorpage");
            return model1;
        }
        model1.addObject("regnum", a);

        model1.setViewName("Historydetails");

        return model1;
    }
    @RequestMapping(value = "/Historydetails", method = RequestMethod.GET)
    public String historydetails() {
        return "Historydetails";
    }
    @RequestMapping(value = "/errorpage", method = RequestMethod.GET)
    public String epage() {
        return "errorpage";
    }


}


