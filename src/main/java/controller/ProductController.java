package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Product;


@Controller
public class ProductController {
    @RequestMapping("/addProduct")
    public ModelAndView add(Product p) throws Exception {
        ModelAndView mav = new ModelAndView("showProduct");
        return mav;
    }
    @RequestMapping("/jump")
    public ModelAndView jump222() {
        ModelAndView mav = new ModelAndView("redirect:/index");
    //    ModelAndView mav = new ModelAndView("index");
    //    ModelAndView mav = new ModelAndView("/index");
        return mav;
    }
}
