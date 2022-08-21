package app_mini_crm.minicrm.service;

import app_mini_crm.minicrm.entity.Pupil;
import app_mini_crm.minicrm.payload.ApiResponse;
import app_mini_crm.minicrm.payload.ReqLid;
import app_mini_crm.minicrm.payload.ResPupilOne;
import app_mini_crm.minicrm.repository.LidRepository;
import app_mini_crm.minicrm.repository.rest.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LidService {
    @Autowired
    LidRepository lidRepository;

    @Autowired
    CourseRepository courseRepository;

    public ApiResponse addLid(ReqLid reqLid) {
        boolean b = lidRepository.existsPupilByPhoneNumber(reqLid.getPhoneNumber());
        if (!b) {
            Pupil pupil = new Pupil(
                    reqLid.getName(),
                    reqLid.getSurname(),
                    reqLid.getPhoneNumber(),
                    "REGISTER",
                    courseRepository.findById(reqLid.getCourseId()).orElseThrow(() -> new ResourceNotFoundException("getCourse")),
                    reqLid.getFromWhere()
            );
            lidRepository.save(pupil);
            return new ApiResponse("successfully saved lid", true);
        } else {
            return new ApiResponse("Bunday pupil mavjud", false);
        }
    }

    public ApiResponse editLid(UUID id, ReqLid reqLid) {
        Optional<Pupil> byId = lidRepository.findById(id);
        if (byId.isPresent()) {
            Pupil pupil = byId.get();
            pupil.setLidStatus(reqLid.getLidStatus());
            lidRepository.save(pupil);
            return new ApiResponse("successfully edited lidStatus", true);
        } else {
            return new ApiResponse("bunday lid mavjud emas", false);
        }
    }

    public List<ResPupilOne> getFromWhereByPupil(String fromWhere) {
        List<Pupil> allPupilByLidStatus = lidRepository.findAllPupilByFromWhere(fromWhere);
        List<ResPupilOne> resLidList = new ArrayList<>();
        for (Pupil pupil : allPupilByLidStatus) {
            ResPupilOne resLid = new ResPupilOne(
                    pupil.getId(),
                    pupil.getName(),
                    pupil.getSurname(),
                    pupil.getPhoneNumber(),
                    pupil.getLidStatus(),
                    pupil.getCourse(),
                    pupil.getFromWhere()
            );
            resLidList.add(resLid);
        }
        System.err.println(resLidList);
        return resLidList;
    }

//
//    public List<ResPupilOne> getPupilByLidStatus(String lidStatus) {
//        List<Pupil> allPupilByLidStatus = lidRepository.findAllPupilByLidStatus(lidStatus);
//        List<ResPupilOne> resLidList = new ArrayList<>();
//        for (Pupil pupil : allPupilByLidStatus) {
//            ResPupilOne resLid = new ResPupilOne(
//                    pupil.getId(),
//                    pupil.getName(),
//                    pupil.getSurname(),
//                    pupil.getPhoneNumber(),
//                    pupil.getLidStatus(),
//                    pupil.getCourse(),
//                    pupil.getFromWhere()
//            );
//            resLidList.add(resLid);
//        }
//        System.err.println(resLidList);
//        return resLidList;
//    }


    public Pupil getOneLid(UUID uuid) {
        Optional<Pupil> byId = lidRepository.findById(uuid);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            return null;
        }
    }

}
