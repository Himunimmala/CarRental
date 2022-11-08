package com.CarRental.Controller;

import com.CarRental.Controller.bean.User;
import com.CarRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Welcome() {
        return "Welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String UserLoginPage(ModelMap model, @RequestParam String userId, @RequestParam String password) {
        User user=userService.getUserByUserId(userId);
        if(user.getPassword().equals(password)){
            model.put("userId",userId);
            return "userloginpage";
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
        if(password !=Cpassword)
        {
            System.out.println("no");
            model.put("Msg", "Passwords should be same");
            return "register";
        }
        if(!Email.contains("@"))
        {
            model.put("Msg","Enter mail properly");
            return "register";
        }
        int user=userService.addUser(Name, Email,mobile,password,   Cpassword);
//        if(user.getPassword().equals(password)){
//            model.put("userId",userId);
//            return "userloginpage";
//        }
        model.put("Msg","Successfull");
        return "userloginpage";
    }
}


