package app_mini_crm.minicrm.service;

import app_mini_crm.minicrm.entity.DarsVaqtlari;
import app_mini_crm.minicrm.entity.Group;
import app_mini_crm.minicrm.payload.ApiResponse;
import app_mini_crm.minicrm.payload.DarsVatiDto;
import app_mini_crm.minicrm.repository.DarsVaqtlariRepository;
import app_mini_crm.minicrm.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DarsVaqtlariService {
    @Autowired
    DarsVaqtlariRepository darsVaqtlariRepository;

    @Autowired
    GroupRepository groupRepository;

    public ApiResponse saveDarsVaqti(DarsVatiDto darsVatiDto) {
        Optional<Group> byId = groupRepository.findById(darsVatiDto.getGroupId());
        if (byId.isPresent()) {
            Group group = groupRepository.findById(darsVatiDto.getGroupId()).get();
            DarsVaqtlari darsVaqtlari = new DarsVaqtlari(
                    group,
                    darsVatiDto.getDarsSoati(),
                    darsVatiDto.getDarsKunlari()
            );
            darsVaqtlariRepository.save(darsVaqtlari);
            return new ApiResponse("successfully saved dars vaqti", true);
        }
        return new ApiResponse("bunday guruh mavjud emas", false);
    }

    public DarsVaqtlari getOneDarsVaqti(UUID id) {
        return darsVaqtlariRepository.findByGroups_Id(id);
    }

    public ApiResponse editDars(UUID id, DarsVatiDto darsVatiDto) {
        Optional<DarsVaqtlari> byId = darsVaqtlariRepository.findById(id);
        if (byId.isPresent()) {
            DarsVaqtlari darsVaqtlari = byId.get();
            darsVaqtlari.setDarsSoati(darsVaqtlari.getDarsSoati());
            darsVaqtlari.setDarsKunlari(darsVaqtlari.getDarsKunlari());
            darsVaqtlariRepository.save(darsVaqtlari);
            return new ApiResponse("successfully edited dars", true);
        }
        return new ApiResponse("bunday dars vaqti mavjud emas", false);
    }
}
