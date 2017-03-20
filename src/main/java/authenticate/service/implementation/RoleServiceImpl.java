package authenticate.service.implementation;

import authenticate.dao.interfaces.GenericDao;
import authenticate.dao.interfaces.RoleDao;
import authenticate.model.Role;

public class RoleServiceImpl extends GenericServiceImpl<Role> {
    /**
     * Instance of dao implementation.
     */
    private RoleDao roleDao;


    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    /**
     * Gets dao instance.
     * @return dao instance.
     */
    @Override
    GenericDao<Role> getDao() {
        return roleDao;
    }
}
