package app_mini_crm.minicrm.service;

import app_mini_crm.minicrm.entity.User;
import app_mini_crm.minicrm.payload.ApiResponse;
import app_mini_crm.minicrm.payload.ReqRegister;
import app_mini_crm.minicrm.repository.RoleRepository;
import app_mini_crm.minicrm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public AuthService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public ApiResponse register(ReqRegister request) {
        try {
//            PasswordEncoder passwordEncoder = new ;
            if (request.getPassword().equals(request.getPrePassword())) {
                if (!userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
                    User user = new User(
                            request.getFirstName(),
                            request.getLastName(),
                            "+" + request.getPhoneNumber(),
                            request.getEmail(),
                            passwordEncoder().encode(request.getPassword()),
                            Collections.singletonList(roleRepository.findById(request.getRoleId()).orElseThrow(() -> new ResourceNotFoundException("getRole")))
                    );
                    userRepository.save(user);
                    return new ApiResponse("User saqlandi", true);
                } else {
                    return new ApiResponse("Bunday user bor", false);
                }
            } else {
                return new ApiResponse("Parollar mos emas", false);
            }
        } catch (Exception e) {
            return new ApiResponse("Xatolik", false);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        return userRepository.findUserByPhoneNumber(phoneNumber).orElseThrow(() -> new UsernameNotFoundException("getUser"));

    }

    public UserDetails getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getUser"));
    }

    public User getOneUser(UUID id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            return user;
        }
        return null;
    }

    public ApiResponse deleteUser(UUID uuid) {
        Optional<User> byId = userRepository.findById(uuid);
        if (byId.isPresent()) {
            User user = byId.get();
            userRepository.delete(user);
            return new ApiResponse("successfully deleted user", true);
        } else {
            return new ApiResponse("bunday user mavjud emas", false);
        }
    }

    public ApiResponse editUser(UUID id, ReqRegister reqRegister) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            if (reqRegister.getPassword().equals(reqRegister.getPrePassword())) {
//                List<Integer> roles = new ArrayList<>();
//                roles = null;
//                    if (reqRegister.getRoleId()==1){
//                        roles.add(1);
//                        roles.add(2);
//                    }else if (reqRegister.getRoleId()==2){
//                        roles.add(2);
//                    }else {
//                        roles.add(null);
//                    }
                User user = byId.get();
                user.setFirstName(reqRegister.getFirstName());
                user.setLastName(reqRegister.getLastName());
                user.setPhoneNumber("+" + reqRegister.getPhoneNumber());
                user.setEmail(reqRegister.getEmail());
                user.setPassword(reqRegister.getPassword());
                user.setRoles(Collections.singletonList(roleRepository.findById(reqRegister.getRoleId()).orElseThrow(() -> new ResourceNotFoundException("getRole"))));
                userRepository.save(user);
                return new ApiResponse("successfully saved user", true);
            } else {
                return new ApiResponse("password va prePassword teng bolishi shart", false);
            }
        } else {
            return new ApiResponse("bunday user mavjud emas", false);
        }
    }
}
