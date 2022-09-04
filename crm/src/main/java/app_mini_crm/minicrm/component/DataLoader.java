package app_mini_crm.minicrm.component;

import app_mini_crm.minicrm.entity.Color;
import app_mini_crm.minicrm.entity.Role;
import app_mini_crm.minicrm.entity.enums.RoleName;
import app_mini_crm.minicrm.entity.User;
import app_mini_crm.minicrm.repository.ColorRepository;
import app_mini_crm.minicrm.repository.RoleRepository;
import app_mini_crm.minicrm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ColorRepository colorRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String initMode;

    @Override
    public void run(String... args) throws Exception {
        if (initMode.equals("never")) {
            colorRepository.save(
                    new Color(
                            1,
                            "white"
                    )
            );
            roleRepository.save(
                    new Role(
                            RoleName.ADMIN
                    )
            );
            roleRepository.save(
                    new Role(
                            RoleName.TEACHER
                    )
            );
            roleRepository.save(
                    new Role(
                            RoleName.SUPER_ADMIN
                    )
            );
            userRepository.save(
                    new User(
                            "Sayfullo",
                            "To'xtayev",
                            "+998990763246",
                            "sayfullogithub@gmail.com",
                            passwordEncoder.encode("Root123_9*12"),
                            roleRepository.findAll()
                    )
            );
            userRepository.save(
                    new User(
                            "tesha",
                            "ketmon",
                            "+998999999999",
                            "ketmon@gmail.com",
                            passwordEncoder.encode("Ketmon123"),
                            Arrays.asList(roleRepository.findById(1).orElseThrow(() -> {
                                return new ResourceNotFoundException("getRole");
                            }), roleRepository.findById(2).orElseThrow(() -> new ResourceNotFoundException("getRole")))
                    )
            );
            userRepository.save(
                    new User(
                            "bolta",
                            "teacher",
                            "+998990000000",
                            "ketmon@gmail.com",
                            passwordEncoder.encode("Ketmon123"),
                            Collections.singletonList(roleRepository.findById(2).orElseThrow(() -> {
                                return new ResourceNotFoundException("getRole");
                            }))
                    )
            );

            userRepository.save(
                    new User(
                            "hechkim",
                            "kech",
                            "+998911111111",
                            "ketmon@gmail.com",
                            passwordEncoder.encode("kimsan12"),
                            null
                    )
            );

        }
    }
}
