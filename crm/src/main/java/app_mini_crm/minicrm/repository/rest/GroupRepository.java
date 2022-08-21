package app_mini_crm.minicrm.repository.rest;

import app_mini_crm.minicrm.entity.Course;
import app_mini_crm.minicrm.entity.Group;
import app_mini_crm.minicrm.projection.CustomCourse;
import app_mini_crm.minicrm.projection.CustomGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(path = "group", collectionResourceRel = "list", excerptProjection = CustomGroup.class)
public interface GroupRepository extends JpaRepository<Group, UUID> {
}
