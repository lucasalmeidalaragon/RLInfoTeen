package br.com.meublog.model.business;

import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author fernando
 */
@MappedSuperclass
public abstract class Person extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255)
    private String nickname;

    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date born;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Person() {
        this.user = new User();
        this.born = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.user);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", email=" + email + '}';
    }

}
