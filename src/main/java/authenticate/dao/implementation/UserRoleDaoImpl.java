package authenticate.dao.implementation;

import authenticate.dao.interfaces.UserRoleDao;
import authenticate.model.UserRole;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserRoleDaoImpl extends GenericDaoImpl<UserRole> implements UserRoleDao{

    UserRoleDaoImpl() {
        super(UserRole.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    EntityManager getEntityManager() {
        return entityManager;
    }
}
