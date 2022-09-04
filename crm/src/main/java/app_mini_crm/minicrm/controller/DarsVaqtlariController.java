package app_mini_crm.minicrm.controller;

import app_mini_crm.minicrm.entity.DarsVaqtlari;
import app_mini_crm.minicrm.payload.ApiResponse;
import app_mini_crm.minicrm.payload.DarsVatiDto;
import app_mini_crm.minicrm.repository.DarsVaqtlariRepository;
import app_mini_crm.minicrm.service.DarsVaqtlariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/darsVaqtlari")
public class DarsVaqtlariController {

    @Autowired
    DarsVaqtlariService darsVaqtlariService;

    @Autowired
    DarsVaqtlariRepository darsVaqtlariRepository;

    @PostMapping
    public HttpEntity<?> addDarsVaqti(@RequestBody DarsVatiDto darsVatiDto) {
        ApiResponse apiResponse = darsVaqtlariService.saveDarsVaqti(darsVatiDto);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getDarsVaqti() {
        List<DarsVaqtlari> all = darsVaqtlariRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getDarsVaqtiByGroup(@PathVariable UUID id) {
        DarsVaqtlari oneDarsVaqti = darsVaqtlariService.getOneDarsVaqti(id);
        return ResponseEntity.ok(oneDarsVaqti);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editDarsByGroup(@PathVariable UUID id, @RequestBody DarsVatiDto darsVatiDto) {
        ApiResponse apiResponse = darsVaqtlariService.editDars(id, darsVatiDto);
        return ResponseEntity.ok(apiResponse);
    }
}
