package app_mini_crm.minicrm.entity;

import app_mini_crm.minicrm.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.File;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "groups")
public class Group extends AbsEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String file;
}
