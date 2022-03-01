package by.shcharbunou.dal.entity.group;

import by.shcharbunou.dal.entity.BaseEntity;
import by.shcharbunou.dal.entity.enums.group.GroupAge;
import by.shcharbunou.dal.entity.enums.group.GroupDesignation;
import by.shcharbunou.dal.entity.enums.group.GroupLevel;
import by.shcharbunou.dal.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor

@Entity
@Table(name = "group")
@AttributeOverride(name = "id", column = @Column(name = "group_id"))
public class Group extends BaseEntity {
    @Column(name = "group_designation")
    @Enumerated(EnumType.STRING)
    private GroupDesignation designation;

    @Column(name = "group_level")
    @Enumerated(EnumType.STRING)
    private GroupLevel level;

    @Column(name = "group_age")
    @Enumerated(EnumType.STRING)
    private GroupAge age;

    @Column(name = "group_days")
    private String days;

    @Column(name = "group_time")
    private String time;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    @Deprecated
    public Group() {}
}