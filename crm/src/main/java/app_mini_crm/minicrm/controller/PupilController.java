package app_mini_crm.minicrm.controller;

import app_mini_crm.minicrm.entity.Pupil;
import app_mini_crm.minicrm.payload.ApiResponse;
import app_mini_crm.minicrm.payload.PupilEdit;
import app_mini_crm.minicrm.payload.ReqPupil;
import app_mini_crm.minicrm.repository.PupilRepository;
import app_mini_crm.minicrm.service.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pupil")
public class PupilController {
    @Autowired
    PupilRepository pupilRepository;

    @Autowired
    PupilService pupilService;

    @PostMapping
    public HttpEntity<?> addPupil(@RequestBody ReqPupil reqPupil) {
        ApiResponse apiResponse = pupilService.savePupil(reqPupil);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getAllPupil() {
        List<Pupil> all = pupilRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deletePupil(@PathVariable UUID id) {
        ApiResponse apiResponse = pupilService.deletePupils(id);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editPupil(@PathVariable UUID id, @RequestBody ReqPupil reqPupil) {
        ApiResponse apiResponse = pupilService.editPupil(id, reqPupil);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOnePupil(@PathVariable UUID id) {
        Pupil one = pupilService.getOne(id);
        return ResponseEntity.ok(one);
    }

    @PutMapping("/one/{id}")
    public HttpEntity<?> getOneEdit(@PathVariable UUID id, @RequestBody PupilEdit pupilEdit) {
        if (!pupilEdit.getName().equals("")) {
            ApiResponse apiResponse = pupilService.editName(id, pupilEdit);
            return ResponseEntity.ok(apiResponse);
        } else {
            return null;
        }
    }
}
