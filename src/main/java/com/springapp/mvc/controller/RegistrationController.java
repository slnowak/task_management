package com.springapp.mvc.controller;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.UserRole;
import com.springapp.mvc.service.UserRoleService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by novy on 02.06.14.
 */

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserService userService;
    private UserRoleService userRoleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String displayRegisterForm(@ModelAttribute("user") User user, ModelMap modelMap) {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUserFromForm(@ModelAttribute("user") User user, BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        // TODO: code below is only temporary, fix it
        user.setActive(true);
        UserRole userRole = new UserRole(UserRole.Role.ROLE_USER, user);
        user.addRole(userRole);
        encodePassword(user);
        userService.create(user);
        userRoleService.create(userRole);

        return "redirect:/home";
    }

    private void encodePassword(User user) {
        final String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
    }
}
