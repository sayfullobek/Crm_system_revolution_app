package app_mini_crm.minicrm.repository;

import app_mini_crm.minicrm.entity.DarsVaqtlari;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DarsVaqtlariRepository extends JpaRepository<DarsVaqtlari, UUID> {
    DarsVaqtlari findByGroups_Id(UUID groups_id);
}
