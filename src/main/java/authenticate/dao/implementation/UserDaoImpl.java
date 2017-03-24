package authenticate.dao.implementation;

import authenticate.dao.interfaces.UserDao;
import authenticate.model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    UserDaoImpl() {
        super(User.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        try{
            String sqlQuery = String.format("SELECT u FROM User AS u WHERE " +
                    "u.username = '%s' AND u.password = '%s'",username, password);
            Query query = getEntityManager().createQuery(sqlQuery);
            return (User) query.getSingleResult();
        } catch (Throwable e){
            return null;
        }
    }
}
