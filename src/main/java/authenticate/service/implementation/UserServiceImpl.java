package authenticate.service.implementation;

import authenticate.dao.interfaces.GenericDao;
import authenticate.dao.interfaces.RoleDao;
import authenticate.dao.interfaces.UserDao;
import authenticate.model.Role;
import authenticate.model.User;
import authenticate.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {
    /**
     * Instance of dao implementation.
     */
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.read(1));
        user.setRoles(roles);
        userDao.create(user);
    }

    /**
     * Gets dao instance.
     * @return dao instance.
     */
    @Override
    GenericDao<User> getDao() {
        return userDao;
    }
}
