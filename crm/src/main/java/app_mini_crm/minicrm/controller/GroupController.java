package app_mini_crm.minicrm.controller;

import app_mini_crm.minicrm.entity.Group;
import app_mini_crm.minicrm.payload.ApiResponse;
import app_mini_crm.minicrm.payload.GroupDto;
import app_mini_crm.minicrm.repository.GroupRepository;
import app_mini_crm.minicrm.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    @Autowired
    GroupService groupService;

    @Autowired
    GroupRepository groupRepository;

    @PostMapping
    public HttpEntity<?> saveGroup(@RequestBody GroupDto groupDto) {
        ApiResponse apiResponse = groupService.addGroup(groupDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping
    public HttpEntity<?> editGroup(@PathVariable UUID id, @RequestBody GroupDto groupDto) {
        ApiResponse apiResponse = groupService.editGr(id, groupDto);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable UUID id) {
        Group one = groupService.getOne(id);
        return ResponseEntity.ok(one);
    }

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Group> all = groupRepository.findAll();
        return ResponseEntity.ok(all);
    }
}
