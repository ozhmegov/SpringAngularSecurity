package authenticate.controller;

import authenticate.model.User;
import authenticate.service.implementation.UserValidator;
import authenticate.service.interfaces.SecurityService;
import authenticate.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value="/view/registration", method = RequestMethod.POST)
    public void registration(@RequestBody User user, BindingResult bindingResult, HttpServletResponse response) throws IOException {
        userValidator.validate(user, bindingResult);

        if(bindingResult.hasErrors()){
            response.sendRedirect("/view/registration.html");
        }

        userService.save(user);
        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());
        response.sendRedirect("/view/welcome.html");
    }

}
