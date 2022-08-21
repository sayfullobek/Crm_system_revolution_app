package app_mini_crm.minicrm.controller;

import app_mini_crm.minicrm.entity.User;
import app_mini_crm.minicrm.payload.*;
import app_mini_crm.minicrm.repository.UserRepository;
import app_mini_crm.minicrm.security.JwtTokenProvider;
import app_mini_crm.minicrm.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenProvider jwtTokenProvider;


    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody ReqRegister reqRegister) {
        ApiResponse response = authService.register(reqRegister);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT)
                .body(response.isSuccess() ? new ApiResponse(response.getMessage(), true, generateToken(reqRegister.getPhoneNumber())) : response);
    }


    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody ReqLogin request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getPhoneNumber(), request.getPassword())
        );
        User user = userRepository.findUserByPhoneNumber(request.getPhoneNumber()).orElseThrow(() -> new ResourceNotFoundException("getUser"));
        ResToken resToken = new ResToken(generateToken(request.getPhoneNumber()));
        System.out.println(ResponseEntity.ok(getMal(user, resToken)));
        return ResponseEntity.ok(getMal(user, resToken));
    }

    private String generateToken(String phoneNumber) {
        User user = userRepository.findUserByPhoneNumber(phoneNumber).orElseThrow(() -> new UsernameNotFoundException("getUser"));
        return jwtTokenProvider.generateToken(user.getId());
    }

    public GetLogin getMal(User user, ResToken resToken) {
        return new GetLogin(user, resToken);
    }

    @GetMapping
    public HttpEntity<?> getEmployeList() {
        List<User> all = userRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOneEmploye(@PathVariable UUID id) {
        return ResponseEntity.ok(authService.getOneUser(id));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteUser(@PathVariable UUID id) {
        return ResponseEntity.ok(authService.deleteUser(id));
    }


    @PutMapping("/edit/{id}")
    public HttpEntity<?> editUser(@PathVariable UUID id, @RequestBody ReqRegister reqRegister){
        ApiResponse response = authService.editUser(id,reqRegister);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT)
                .body(response.isSuccess() ? new ApiResponse(response.getMessage(), true, generateToken(reqRegister.getPhoneNumber())) : response);
    }
}
