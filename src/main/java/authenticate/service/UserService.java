package authenticate.service;

import authenticate.dao.interfaces.UserDao;
import authenticate.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class UserService implements UserDetailsService {

    private UserDao userDao;


    public UserService(){

    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User result = userDao.getUserByName(username);
        if(result == null)
            throw new UsernameNotFoundException("User not found.");
        return result;
    }
}
