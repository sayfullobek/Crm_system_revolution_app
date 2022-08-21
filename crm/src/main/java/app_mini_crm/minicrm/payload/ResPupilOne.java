package app_mini_crm.minicrm.payload;

import app_mini_crm.minicrm.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NotNull
public class ResPupilOne {
    private UUID id;

    private String name;

    private String surname;

    //    @Pattern(regexp = "^[+][9][9][8][0-9]{9}$", message = "Phone number must be 13 digits.")
    private String phoneNumber;

    private String lidStatus;

    private Course course;

    private String fromWhere;

    private Integer groupId;

    public ResPupilOne(UUID id, String name, String surname, String phoneNumber, String lidStatus, Course course, String fromWhere) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.lidStatus = lidStatus;
        this.course = course;
        this.fromWhere = fromWhere;
    }

    public ResPupilOne(String lidStatus) {
        this.lidStatus = lidStatus;
    }
}
