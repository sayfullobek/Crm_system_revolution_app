package app_mini_crm.minicrm.repository;

import app_mini_crm.minicrm.entity.Role;
import app_mini_crm.minicrm.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(RoleName roleName);

}
