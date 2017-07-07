package br.com.meublog.model.business;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(length = 255, nullable = false, unique = true)
    private String login;

    @Column(length = 255, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.login);
        hash = 67 * hash + Objects.hashCode(this.userType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (this.userType != other.userType) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "login=" + login + ", userType=" + userType + '}';
    }

}
