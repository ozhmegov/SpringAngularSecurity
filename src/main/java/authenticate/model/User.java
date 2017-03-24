package authenticate.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> userRoles;

    public User(){
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
     * Gets username.
     *
     * @return username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the new value.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the new value.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets userRoles.
     *
     * @return userRoles.
     */
    public Set<Role> getUserRoles() {
        return userRoles;
    }

    /**
     * Sets userRoles.
     *
     * @param userRoles the new value.
     */
    public void setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
    }
}
