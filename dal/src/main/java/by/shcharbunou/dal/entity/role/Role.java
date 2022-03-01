package by.shcharbunou.dal.entity.role;

import by.shcharbunou.dal.entity.BaseEntity;
import by.shcharbunou.dal.entity.enums.RoleDesignation;
import by.shcharbunou.dal.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor

@Entity
@Table(name = "role")
@AttributeOverride(name = "id", column = @Column(name = "role_id"))
public class Role extends BaseEntity {
    @Column(name = "role_designation")
    @Enumerated(EnumType.STRING)
    private RoleDesignation roleDesignation;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users = new HashSet<>();

    public void connectUser(User user) {
        this.users.add(user);
        user.setRole(this);
    }

    @Deprecated
    public Role() {}
}
