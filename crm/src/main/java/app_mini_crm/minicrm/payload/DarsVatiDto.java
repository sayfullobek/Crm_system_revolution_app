package app_mini_crm.minicrm.payload;

import app_mini_crm.minicrm.entity.Group;
import app_mini_crm.minicrm.entity.Pupil;
import app_mini_crm.minicrm.entity.enums.DarsKunlari;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DarsVatiDto {
    private UUID id;

    private UUID groupId;

    private List<Pupil> pupils;

    private String DarsSoati;

    private DarsKunlari darsKunlari;

    public DarsVatiDto(UUID groupId, String darsSoati, DarsKunlari darsKunlari) {
        this.groupId = groupId;
        this.DarsSoati = darsSoati;
        this.darsKunlari = darsKunlari;
    }
}
