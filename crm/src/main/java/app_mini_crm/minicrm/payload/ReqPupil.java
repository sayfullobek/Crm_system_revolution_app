package app_mini_crm.minicrm.payload;

import app_mini_crm.minicrm.entity.Course;
import app_mini_crm.minicrm.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqPupil {
    private String name;

    private String surname;

    private String phoneNumber;

    private String lidStatus;

    private Integer courseId;

    private String fromWhere;

    private Date birthDate;

    private double balance;

    private UUID group;

    public ReqPupil(String name, String surname, String phoneNumber, String lidStatus, Integer courseId, String fromWhere, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.lidStatus = lidStatus;
        this.courseId = courseId;
        this.fromWhere = fromWhere;
        this.birthDate = birthDate;
    }

    public ReqPupil(String name, String surname, String phoneNumber, String lidStatus, UUID group, String fromWhere, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.lidStatus = lidStatus;
        this.group = group;
        this.fromWhere = fromWhere;
        this.birthDate = birthDate;
    }
}
