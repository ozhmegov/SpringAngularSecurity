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
    public User findByUsername(String username) {
        try{
            Query query = getEntityManager()
                    .createQuery("FROM User u WHERE u.username=:username");
            query.setParameter("username", username);
            return (User) query.getSingleResult();
        } catch (Throwable e){
            return null;
        }
    }
}
