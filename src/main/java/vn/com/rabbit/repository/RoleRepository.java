package vn.com.rabbit.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.rabbit.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {


}
