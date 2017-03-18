package authenticate.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int userId;

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

    public User(){
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name="user_role", joinColumns = @JoinColumns(name="user_id"),
//            inverseJoinColumns = @JoinColumns(name="role_id"))
    private Set<UserRole> userRoles = new HashSet<UserRole>();

    /**
     * Gets login.
     *
     * @return login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login the new value.
     */
    public void setLogin(String login) {
        this.login = login;
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
     * Gets password.
     *
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> result = new ArrayList<SimpleGrantedAuthority>();

        for(UserRole userRole : userRoles){
            result.add(new SimpleGrantedAuthority(userRole.getListRole().name()));
        }

        return result;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
