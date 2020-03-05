package doan.stores.controller.controller;

import doan.stores.bussiness.BaseService;
import doan.stores.bussiness.UserService;
import doan.stores.domain.User;
import doan.stores.dto.request.ChangePasswordRequest;
import doan.stores.dto.response.ErrorResponse;
import doan.stores.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private BaseService baseService;

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
        } else {
            mav.setViewName("redirect:/admin/home");
        }
        return mav;
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> changePassword(@Valid @RequestBody ChangePasswordRequest request, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        List<ErrorResponse> errors = baseService.bindingResult(result);
        if (errors.isEmpty()) {
            User user = baseService.getPrincipal();
            if (userService.checkPassword(user.getUserName(), request.getPasswordOld())) {
                userService.changePassword(user.getUserName(), request.getPasswordNew());
                map.put("status", 200);
            } else {
                map.put("status", 100);
                errors.add(new ErrorResponse("passwordOld", "Mật khẩu không đúng"));
                map.put("errors", errors);
            }
        } else {
            map.put("status", 100);
            map.put("errors", errors);
        }
        return map;
    }

}
