package app_mini_crm.minicrm.service;

import app_mini_crm.minicrm.entity.Group;
import app_mini_crm.minicrm.payload.ApiResponse;
import app_mini_crm.minicrm.payload.GroupDto;
import app_mini_crm.minicrm.repository.GroupRepository;
import app_mini_crm.minicrm.repository.rest.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    CourseRepository courseRepository;

    public ApiResponse addGroup(GroupDto groupDto) {
        boolean b = groupRepository.existsGroupByNameEqualsIgnoreCase(groupDto.getName());
        if (!b) {
            Group group = new Group(
                    groupDto.getName(),
                    courseRepository.findById(groupDto.getCourseId()).orElseThrow(() -> new ResourceNotFoundException("getCourse"))
            );
            groupRepository.save(group);
            return new ApiResponse("Successfully saved group", true);
        }
        return new ApiResponse("bunday guruh mavjud", false);
    }

    public ApiResponse editGr(UUID id, GroupDto groupDto) {
        Optional<Group> byId = groupRepository.findById(id);
        if (byId.isPresent()) {
            boolean b = groupRepository.existsGroupByNameEqualsIgnoreCaseAndIdNot(groupDto.getName(), id);
            if (!b) {
                Group group1 = byId.get();
                group1.setName(groupDto.getName());
                group1.setCourse(courseRepository.findById(groupDto.getCourseId()).orElseThrow(() -> new ResourceNotFoundException("getCourse")));
                groupRepository.save(group1);
                return new ApiResponse("Successfully saved group", true);
            }
            return new ApiResponse("bunday guruh mavjud", false);
        }
        return new ApiResponse("bunday guruh mavjud emas", false);
    }

    public Group getOne(UUID uuid) {
        Optional<Group> byId = groupRepository.findById(uuid);
        if (byId.isPresent()) {
            Group group = byId.get();
            return group;
        }
        return null;
    }
}
