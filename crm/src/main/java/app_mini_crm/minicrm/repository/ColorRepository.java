package app_mini_crm.minicrm.repository;

import app_mini_crm.minicrm.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
public interface ColorRepository extends JpaRepository<Color, Integer> {
}
