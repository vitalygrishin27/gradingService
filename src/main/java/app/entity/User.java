package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String EncryptedPassword;
    @Column(insertable = false, updatable = false)
    private String password;
    @Column(name = "role", nullable = false)
    private Role role;
    @Column(nullable = false)
    private String firstName;
    private String secondName;
    private String lastName;
    private String position;
    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable (name="contest_users",
            joinColumns = @JoinColumn(name = "contest_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    @Fetch(FetchMode.SUBSELECT)
    private List<Contest> contests;
    @Lob
    private String photo;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<Performance> performances;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", role=" + role +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
