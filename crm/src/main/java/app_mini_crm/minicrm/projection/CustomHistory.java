package app_mini_crm.minicrm.projection;

import app_mini_crm.minicrm.entity.Course;
import app_mini_crm.minicrm.entity.History;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Projection(types = History.class, name = "customHistory")
public interface CustomHistory {
    UUID getId();

    String getName();

    String getSurname();

    String getRole();

    String getNimaQildi();

    Date getQachon();
}
