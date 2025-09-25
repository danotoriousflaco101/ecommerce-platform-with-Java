package com.flaco.ecommerce_platform.repository;

import com.flaco.ecommerce_platform.model.ERole;
import com.flaco.ecommerce_platform.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}