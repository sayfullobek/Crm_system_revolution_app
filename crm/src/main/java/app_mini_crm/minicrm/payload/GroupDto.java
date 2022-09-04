package app_mini_crm.minicrm.payload;

import app_mini_crm.minicrm.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    private String name;

    private Integer courseId;
}
