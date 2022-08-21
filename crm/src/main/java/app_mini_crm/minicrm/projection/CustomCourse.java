package app_mini_crm.minicrm.projection;

import app_mini_crm.minicrm.entity.Course;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Course.class, name = "customCourse")
public interface CustomCourse {
    Integer getId();

    String getUzName();

    String getEnName();

    String getRuName();
}
