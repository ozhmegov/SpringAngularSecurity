package authenticate.dao.implementation;

import authenticate.dao.interfaces.RoleDao;
import authenticate.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {

    RoleDaoImpl() {
        super(Role.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    EntityManager getEntityManager() {
        return entityManager;
    }
}
