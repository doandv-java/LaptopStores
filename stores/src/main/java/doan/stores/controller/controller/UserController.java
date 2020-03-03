package doan.stores.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * View page of customer
 */
@Controller
public class UserController {

    @GetMapping("/home")
    public ModelAndView viewHome() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

    @GetMapping("/cart")
    public ModelAndView viewCart() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("cart");
        return mav;
    }

    @GetMapping("/order/history")
    public ModelAndView viewOrderHistory() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("order_history");
        return mav;
    }

    @GetMapping("/product")
    public ModelAndView viewProduct() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("products");
        return mav;
    }

    @GetMapping("/detail")
    public ModelAndView viewDetails() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("details");
        return mav;
    }
}
