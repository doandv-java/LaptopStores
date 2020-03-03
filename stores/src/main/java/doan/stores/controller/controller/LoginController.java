package doan.stores.controller.controller;

import doan.stores.bussiness.UserService;
import doan.stores.domain.User;
import doan.stores.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView viewLogin() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", new User());
        mav.setViewName("login");
        return mav;
    }

    @GetMapping("/checkUser")
    public ModelAndView checkUser() {
        ModelAndView mav = new ModelAndView();
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findUserByUserName(principal.getUsername());
        if (user.getRole().equals(RoleEnum.ROLE_CUSTOMER.getText())) {
            mav.setViewName("redirect:/home");
        } else{
            mav.setViewName("redirect:/admin/home");
        }
        return mav;
    }

}
