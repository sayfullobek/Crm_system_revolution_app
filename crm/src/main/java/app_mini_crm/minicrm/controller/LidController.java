package app_mini_crm.minicrm.controller;

import app_mini_crm.minicrm.entity.Pupil;
import app_mini_crm.minicrm.payload.ApiResponse;
import app_mini_crm.minicrm.payload.ReqLid;
import app_mini_crm.minicrm.payload.ResPupilOne;
import app_mini_crm.minicrm.repository.LidRepository;
import app_mini_crm.minicrm.service.LidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lid")
public class LidController {
    @Autowired
    LidService lidService;

    @Autowired
    LidRepository lidRepository;

    @GetMapping("/list")
    public HttpEntity<?> getAllLid() {
        List<Pupil> all = lidRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public HttpEntity<?> addLid(@RequestBody ReqLid reqLid) {
        ApiResponse apiResponse = lidService.addLid(reqLid);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editLid(@PathVariable UUID id, @RequestBody ReqLid reqLid) {
        ApiResponse apiResponse = lidService.editLid(id, reqLid);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/fromWhere/{fromWhere}")
    public HttpEntity<?> getFromWhere(@PathVariable String fromWhere) {
        List<ResPupilOne> fromWhereByPupil = lidService.getFromWhereByPupil(fromWhere);
        return ResponseEntity.ok(fromWhereByPupil);
    }

//    @GetMapping("/lidStatus/{lidStatus}")
//    public HttpEntity<?> getLidStatus(@PathVariable String lidStatus) {
//        List<ResPupilOne> fromWhereByPupil = lidService.getPupilByLidStatus(lidStatus);
//        return ResponseEntity.ok(fromWhereByPupil);
//    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOneLid(@PathVariable UUID id) {
        Pupil oneLid = lidService.getOneLid(id);
        return ResponseEntity.ok(oneLid);
    }
}
