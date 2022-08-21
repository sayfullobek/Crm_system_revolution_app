package app_mini_crm.minicrm.repository;

import app_mini_crm.minicrm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;
import java.util.UUID;

@CrossOrigin
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByPhoneNumber(String phoneNumber);

    Optional<User> findUserByPhoneNumber(String phoneNumber);

//    User findUserByPhoneNumber(String phoneNumber);
}
