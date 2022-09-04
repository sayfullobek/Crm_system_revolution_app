package app_mini_crm.minicrm.entity;

import app_mini_crm.minicrm.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class History extends AbsEntity {
    private String name; //malumotni yangilagan userning ismi
    private String surname; //malumotni yanglilagan userning familiyasi
    private String role; //malumotni yanglilagan userning roli
    private String nimaQildi; //ushbu user nima ish qilgani haqida malumot
    private Date Qachon;
}
