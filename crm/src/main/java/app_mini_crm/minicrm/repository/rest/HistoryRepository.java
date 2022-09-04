package app_mini_crm.minicrm.repository.rest;

import app_mini_crm.minicrm.entity.History;
import app_mini_crm.minicrm.projection.CustomHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;


@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(path = "history", collectionResourceRel = "list", excerptProjection = CustomHistory.class)
public interface HistoryRepository extends JpaRepository<History, UUID> {
}
