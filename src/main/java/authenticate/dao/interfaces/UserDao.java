package authenticate.dao.interfaces;

import authenticate.model.User;

public interface UserDao extends GenericDao<User> {
    User findByUsername(String username);
}
