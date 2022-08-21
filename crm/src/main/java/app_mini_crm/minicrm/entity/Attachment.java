package app_mini_crm.minicrm.entity;

import app_mini_crm.minicrm.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attachment extends AbsEntity {

    @Column(nullable = false)
    private  String name;

    @Column(nullable = false)
    private String contentType;

    @Column(nullable = false)
    private Long size;

}
