package app_mini_crm.minicrm.projection;

import app_mini_crm.minicrm.entity.Course;
import app_mini_crm.minicrm.entity.Group;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(types = Group.class, name = "customGroup")
public interface CustomGroup {
    UUID getId();

    String getName();

    String getFile();
}
