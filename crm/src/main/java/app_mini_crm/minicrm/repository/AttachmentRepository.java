package app_mini_crm.minicrm.repository;

import app_mini_crm.minicrm.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
}
