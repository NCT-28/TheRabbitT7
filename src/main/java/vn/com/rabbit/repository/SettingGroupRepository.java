package vn.com.rabbit.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.rabbit.entity.SettingGroup;

@Repository
public interface SettingGroupRepository extends JpaRepository<SettingGroup,UUID> {

}
