package me.kolupaev.lana.validation.controller;

import me.kolupaev.lana.validation.Constants;
import me.kolupaev.lana.validation.business.User;
import me.kolupaev.lana.validation.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Lana Kolupaev
 * @date 2015-05-18
 */
@Controller
@RequestMapping(value="/user")
public class RegistrationController {
    private static final String USER = "user";
    @Autowired
    private UserService service;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String deleteStudent(ModelMap model) {
        model.addAttribute(USER, new User());
        return Constants.VIEW_REGISTRATION_FORM;
    }

    @RequestMapping(value="/availability", method=RequestMethod.POST)
    public @ResponseBody Boolean getAvailability(@RequestParam String username) {
        return service.validateUsername(username);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createStudent(@Valid @ModelAttribute(USER) User user, BindingResult result) {
        //validation
        if (result.hasErrors()) {
            return Constants.VIEW_REGISTRATION_FORM;
        }

        //attempt to persist
        try {
            service.register(user);
        } catch (UserAlreadyExistsException e) {
            result.rejectValue("username", "Unique.user.username", new Object[] {user.getUsername()}, "Username not available");
            return Constants.VIEW_REGISTRATION_FORM;
        }

        //all good
        return Constants.VIEW_REGISTRATION_SUCCESS;
    }
}
