package vn.com.rabbit.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * An authority (a security role) used by Spring Security.
 */
@Entity
@Table(name = "bl_role")
@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roles", cascade = CascadeType.ALL)
    private List<RoleUser> roleUsers;

    @Column(length = 50)
    private String name;
}
