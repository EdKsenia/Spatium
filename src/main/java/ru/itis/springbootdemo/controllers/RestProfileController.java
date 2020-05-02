package ru.itis.springbootdemo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.ProfileForm;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestProfileController {
    @PostMapping("/api/profile")
    public ResponseEntity<?> updateProfile(@Valid @RequestBody ProfileForm form) {
        return ResponseEntity.ok("All ok");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

