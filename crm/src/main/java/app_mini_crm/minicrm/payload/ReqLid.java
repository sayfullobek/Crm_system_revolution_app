package app_mini_crm.minicrm.payload;

import app_mini_crm.minicrm.entity.Course;
import app_mini_crm.minicrm.entity.Group;
import app_mini_crm.minicrm.entity.enums.FromWhere;
import app_mini_crm.minicrm.entity.enums.LidStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqLid {
    @NotNull
    private String name;

    private String surname;

    @Pattern(regexp = "^[+][9][9][8][0-9]{9}$", message = "Phone number must be 13 digits.")
    private String phoneNumber;

    private String lidStatus;

    private Integer courseId;

    private String fromWhere;

    private Integer groupId;

    public ReqLid(String name, String surname, String phoneNumber, Integer courseId, String fromWhere) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.courseId = courseId;
        this.fromWhere = fromWhere;
    }

    public ReqLid(String lidStatus) {
        this.lidStatus = lidStatus;
    }
}
