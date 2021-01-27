package vn.com.rabbit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.com.rabbit.base.entity.BaseEntity;

/**
 * An authority (a security role) used by Spring Security.
 */
@Entity
@Table(name = "bl_role")
@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roles", cascade = CascadeType.ALL)
    private List<RoleUser> roleUsers;

    @Column(length = 50)
    private String name;
}
