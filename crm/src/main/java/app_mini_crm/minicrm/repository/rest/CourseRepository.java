package app_mini_crm.minicrm.repository.rest;

import app_mini_crm.minicrm.entity.Course;
import app_mini_crm.minicrm.projection.CustomCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(path = "course", collectionResourceRel = "list", excerptProjection = CustomCourse.class)
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
