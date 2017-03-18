package authenticate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int roleId;

    @Enumerated(EnumType.STRING)
    private ListRole listRole;

    public UserRole(){

    }

    @ManyToMany(mappedBy = "userRoles")
    private Set<User> user = new HashSet<User>();

    /**
     * Gets roleId.
     *
     * @return roleId.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets roleId.
     *
     * @param roleId the new value.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets listRole.
     *
     * @return listRole.
     */
    public ListRole getListRole() {
        return listRole;
    }

    /**
     * Sets listRole.
     *
     * @param listRole the new value.
     */
    public void setListRole(ListRole listRole) {
        this.listRole = listRole;
    }
}
