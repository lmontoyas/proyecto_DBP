package com.example.demo.usuario.controller;

import com.example.demo.usuario.dto.AuthResponse;
import com.example.demo.usuario.dto.ErrorMessage;
import com.example.demo.usuario.dto.SignInDTO;
import com.example.demo.usuario.dto.SignUpDTO;
import com.example.demo.usuario.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AtController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@Valid @RequestBody SignInDTO request){

        var respuesta = authenticationService.signin(request);

        if (!Objects.equals(respuesta.getToken(), "")) {
            return ResponseEntity.ok(respuesta);
        }
        else {
            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@Valid @RequestBody SignUpDTO request){

        var respuesta = authenticationService.signup(request);

        if (!Objects.equals(respuesta.getToken(), "")) {
            return ResponseEntity.ok(respuesta);
        }
        else {
            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> validacion(MethodArgumentNotValidException ex) {

        ErrorMessage mensaje = new ErrorMessage(ex.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(400).body(mensaje);
    }
}
