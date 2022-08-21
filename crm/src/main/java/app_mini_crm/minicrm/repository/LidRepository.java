package app_mini_crm.minicrm.repository;

import app_mini_crm.minicrm.entity.Pupil;
import app_mini_crm.minicrm.entity.enums.LidStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
public interface LidRepository extends JpaRepository<Pupil, UUID> {
    boolean existsPupilByPhoneNumber(String phoneNumber);

    List<Pupil> findAllPupilByFromWhere(String fromWhere);

    List<Pupil> findAllPupilByLidStatus(String lidStatus);
}
