package authenticate.service.implementation;

import authenticate.dao.interfaces.GenericDao;
import authenticate.dao.interfaces.UserDao;
import authenticate.model.User;
import authenticate.service.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {
    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void save(User user) {

    }

    /**
     * Instance of dao implementation.
     */
    private UserDao userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
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
