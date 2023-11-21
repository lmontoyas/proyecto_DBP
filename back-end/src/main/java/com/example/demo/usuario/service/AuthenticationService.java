package com.example.demo.usuario.service;

import com.example.demo.usuario.model.Role;
import com.example.demo.usuario.model.User;
import com.example.demo.usuario.dto.AuthResponse;
import com.example.demo.usuario.dto.SignUpDTO;
import com.example.demo.usuario.dto.SignInDTO;
import com.example.demo.usuario.repository.UserRepository;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    ModelMapper mapper = new ModelMapper();

    @Autowired
    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse signin(SignInDTO request) throws IllegalArgumentException {

        Boolean verificar = userRepository.existsByEmail(request.getEmail());

        AuthResponse response = new AuthResponse();

        if (verificar) {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            var user = userRepository.findByEmail(request.getEmail());
            var jwt = jwtService.generateToken(user);

            response.setToken(jwt);
            response.setMessage("Usuario loggeado correctamente!");

        }
        else {

            response.setToken("");
            response.setMessage("Correo no existe, por favor cree una cuenta!");

        }

        return response;

    }
    public AuthResponse signup(SignUpDTO request) {
        var user = mapper.map(request, User.class);

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        if (Objects.equals(user.getUsername(), "sebasurbin@gmail.com")) {
            user.setRole(Role.ADMIN);
        }
        else {
            user.setRole(Role.USER);
        }

        AuthResponse response = new AuthResponse();

        Boolean verificar = userRepository.existsByEmail(user.getEmail());
        if (!verificar) {
            userRepository.save(user);

            var jwt = jwtService.generateToken(user);
            response.setToken(jwt);
            response.setMessage("Cuenta creada, ya puedes Inciar Sesion!");
        }
        else {
            response.setToken("");
            response.setMessage("Correo en uso, ingresar otro!");
        }

        return response;
    }

}
