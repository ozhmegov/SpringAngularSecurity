package authenticate.service.implementation;

import authenticate.model.User;
import authenticate.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User)o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required");
        if(user.getUsername().length() < 8 || user.getUsername().length() > 32){
            errors.rejectValue("username", "Size of username is not valid.");
        }

        if(userService.findByUsername(user.getUsername()) != null){
            errors.rejectValue("username", "Duplicate username.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
        if(user.getPassword().length() < 4 || user.getPassword().length() > 32){
            errors.rejectValue("password", "Size of password is not valid.");
        }

        if(!user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("confirmPassword", "Password do not match.");
        }


    }
}
