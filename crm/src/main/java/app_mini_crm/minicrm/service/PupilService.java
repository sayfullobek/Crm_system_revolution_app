package app_mini_crm.minicrm.service;

import app_mini_crm.minicrm.entity.Group;
import app_mini_crm.minicrm.entity.Pupil;
import app_mini_crm.minicrm.payload.ApiResponse;
import app_mini_crm.minicrm.payload.PupilEdit;
import app_mini_crm.minicrm.payload.ReqPupil;
import app_mini_crm.minicrm.repository.PupilRepository;
import app_mini_crm.minicrm.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PupilService {
    @Autowired
    PupilRepository pupilRepository;

    @Autowired
    GroupRepository groupRepository;

    public ApiResponse savePupil(ReqPupil reqPupil) {
        boolean b = pupilRepository.existsPupilByPhoneNumber(reqPupil.getPhoneNumber());
        if (!b) {
            Pupil pupil = new Pupil(
                    reqPupil.getName(),
                    reqPupil.getSurname(),
                    reqPupil.getPhoneNumber(),
                    "IS_COMING",
                    groupRepository.findById(reqPupil.getGroup()).orElseThrow(() -> new ResourceNotFoundException("getGroup")),
                    reqPupil.getFromWhere()
            );
            pupilRepository.save(pupil);
            return new ApiResponse("successfully saved pupil", true);
        } else {
            return new ApiResponse("bunday user mavjud emas", false);
        }
    }

    public ApiResponse deletePupils(UUID id) {
        Optional<Pupil> byId = pupilRepository.findById(id);
        if (byId.isPresent()) {
            Pupil pupil = byId.get();
            pupilRepository.delete(pupil);
            return new ApiResponse("deleted pupil", true);
        }
        return new ApiResponse("bunday user mavjud emas", false);
    }

    public ApiResponse editPupil(UUID id, ReqPupil reqPupil) {
        boolean b = pupilRepository.existsPupilByPhoneNumberAndIdNot(reqPupil.getPhoneNumber(), id);
        if (!b) {
            Optional<Pupil> byId = pupilRepository.findById(id);
            if (byId.isPresent()) {
                Pupil pupil = byId.get();
                pupil.setName(reqPupil.getName());
                pupil.setSurname(reqPupil.getSurname());
                pupil.setPhoneNumber(reqPupil.getPhoneNumber());
                pupil.setGroup(groupRepository.findById(reqPupil.getGroup()).orElseThrow(() -> new ResourceNotFoundException("getGroup")));
                pupil.setFromWhere(reqPupil.getFromWhere());
                pupil.setBirthDate(reqPupil.getBirthDate());
                pupil.setLidStatus("IS_COMING");
                pupilRepository.save(pupil);
                return new ApiResponse("successfully saved pupil", true);
            } else {
                return new ApiResponse("bunday user yoq", false);
            }
        } else {
            return new ApiResponse("bunday user mavjud", false);
        }
    }

    public Pupil getOne(UUID id) {
        Optional<Pupil> byId = pupilRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            return null;
        }
    }

    public ApiResponse editName(UUID id, PupilEdit pupilEdit) {
        Optional<Pupil> byId = pupilRepository.findById(id);
        Pupil pupil = byId.get();
        if (!pupilEdit.getName().equals("") || pupilEdit.getName() == null) {
            if (pupilEdit.getMalumot().equals("name")) {
                pupil.setName(pupilEdit.getName());
            } else if (pupilEdit.getMalumot().equals("surname")) {
                pupil.setSurname(pupilEdit.getName());
            } else if (pupilEdit.getMalumot().equals("phoneNumber")) {
                pupil.setPhoneNumber(pupilEdit.getName());
            } else if (pupilEdit.getMalumot().equals("fromWhere")) {
                pupil.setFromWhere(pupilEdit.getName());
            } else if (pupilEdit.getMalumot().equals("balance")) {
                double balance = Double.parseDouble(pupilEdit.getName());
                pupil.setBalance(balance);
            } else if (pupilEdit.getMalumot().equals("group")) {
                Group group = groupRepository.findById(UUID.fromString(pupilEdit.getName())).get();
                pupil.setGroup(group);
            }
            pupilRepository.save(pupil);
            return new ApiResponse("successfully pupil edit", true);
        } else {
            return new ApiResponse("malumot kirit qoziboy", false);
        }
    }
}
