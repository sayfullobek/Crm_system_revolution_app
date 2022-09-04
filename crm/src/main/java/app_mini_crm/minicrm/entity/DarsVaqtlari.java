package app_mini_crm.minicrm.entity;

import app_mini_crm.minicrm.entity.enums.DarsKunlari;
import app_mini_crm.minicrm.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DarsVaqtlari extends AbsEntity {
    @ManyToOne(optional = false)
    private Group groups;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Pupil> pupils;

    @NotNull
    private String DarsSoati;

    @Enumerated(EnumType.STRING)
    private DarsKunlari darsKunlari;

    public DarsVaqtlari(Group groups, String darsSoati, DarsKunlari darsKunlari) {
        this.groups = groups;
        DarsSoati = darsSoati;
        this.darsKunlari = darsKunlari;
    }
}
