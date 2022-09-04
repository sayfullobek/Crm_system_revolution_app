package app_mini_crm.minicrm.repository;

import app_mini_crm.minicrm.entity.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
public interface PupilRepository extends JpaRepository<Pupil, UUID> {
    boolean existsPupilByPhoneNumber(String phoneNumber);

    boolean existsPupilByPhoneNumberAndIdNot(String phoneNumber, UUID id);
}
