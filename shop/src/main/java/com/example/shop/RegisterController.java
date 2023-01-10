package com.example.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService service;

    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String index(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "index";
    }

    @GetMapping("/register")
    public String register()
    {
        return "register";
    }

    @PostMapping("/registerEnter")
    public String registerEnter(User user)
    {
        String pwd1 = user.getPassword();
        String pwd2 = user.getPassword2();

        if (pwd1.equals(pwd2))
        {
            service.saveUser(user);
            return "index";
        }
        else
        {
            return "wrong";
        }

    }

    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("user") User user, Model model)
    {
        String userId = user.getUserId();

        Optional<User> userdata = Optional.ofNullable(service.getuserbyId(userId));

        if (user.getPassword().equals(userdata.get().getPassword()))
        {
            model.addAttribute("message", "Welcome " + user.getUserId());
            return "userhome";
        }
        else
        {
            return "loginerror";
        }

    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @PostMapping("/adminLogin")
    public String loginAdmin(@ModelAttribute("admin") Admin admin, Model model)
    {
        String adminId = admin.getAdminId();

        Optional<Admin> admindata = Optional.ofNullable(adminService.getadminbyId(adminId));

        if (admin.getAdminPassword().equals(admindata.get().getAdminPassword()))
        {
            model.addAttribute("message", "Welcome " + admin.getAdminId());
            return "adminhome";
        }
        else
        {
            return "adminloginerror";
        }

    }

}