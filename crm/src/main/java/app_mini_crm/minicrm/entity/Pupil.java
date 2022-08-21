package app_mini_crm.minicrm.entity;

import app_mini_crm.minicrm.entity.enums.FromWhere;
import app_mini_crm.minicrm.entity.enums.LidStatus;
import app_mini_crm.minicrm.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pupil extends AbsEntity {
    @Column(nullable = false)
    private String name;

    private String surname;

    @Column(nullable = false)
    private String phoneNumber;

    //    @Enumerated(EnumType.STRING)
    private String lidStatus;

    @ManyToOne
    private Course course;

    //    @Enumerated(EnumType.STRING)
    private String fromWhere;

    private Date birthDate;

    private double balance;

    @ManyToOne
    private Group group;

    public Pupil(String name, String surname, String phoneNumber, String lidStatus, Course course, String fromWhere) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.lidStatus = lidStatus;
        this.course = course;
        this.fromWhere = fromWhere;
    }
}
