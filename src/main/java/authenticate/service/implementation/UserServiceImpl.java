package authenticate.service.implementation;

import authenticate.dao.interfaces.GenericDao;
import authenticate.dao.interfaces.UserDao;
import authenticate.model.Role;
import authenticate.model.User;
import authenticate.service.interfaces.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("userService")
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService, AuthenticationProvider {

    private UserDao userDao;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        final User user = userDao.findByUsernameAndPassword(username, password);
        if(user != null){
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            for(Role role:user.getUserRoles()){
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getListRole().name()));
            }
            return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    GenericDao<User> getDao() {
        return userDao;
    }

    /**
     * Sets userDao.
     *
     * @param userDao the new value.
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
