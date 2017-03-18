package authenticate.dao.interfaces;

import authenticate.model.User;

public interface UserDao extends GenericDao<User> {
    User getUserByName(String name);
}
