package authenticate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private ListRole listRole;

    @ManyToMany(mappedBy = "userRoles")
    private Set<User> users;

    public Role(){

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

    /**
     * Gets id.
     *
     * @return id.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the new value.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets users.
     *
     * @return users.
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the new value.
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
