package app_mini_crm.minicrm.entity;

import app_mini_crm.minicrm.entity.template.AbsNameEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Course extends AbsNameEntity {
}





