package me.kolupaev.lana.validation.controller;

import me.kolupaev.lana.validation.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Lana Kolupaev
 * @date 2015-05-18
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap model) {
        return Constants.VIEW_INDEX;
    }
}
