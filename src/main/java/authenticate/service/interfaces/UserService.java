package authenticate.service.interfaces;

import authenticate.model.User;

public interface UserService extends GenericService<User> {
    User findByUsername(String username);
    void save(User user);
}
