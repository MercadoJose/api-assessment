package com.example.assessment.controller;

import com.example.assessment.entity.User;
import com.example.assessment.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Crea nuevo usuario
    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    // Lee un usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long idUser){
        Optional<User> oUser = userService.findById(idUser);
        if (!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oUser);
    }

    // Actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User userDetails, @PathVariable(value = "id") Long idUser){
        Optional<User> user = userService.findById(idUser);
        if (!user.isPresent()){
            return ResponseEntity.notFound().build();
        }

        //BeanUtils.copyProperties(userDetails, user.get());
        user.get().setUserName(userDetails.getUserName());
        user.get().setPassword(userDetails.getPassword());
        user.get().setStatus(userDetails.getStatus());
        user.get().setCreatedDate(userDetails.getCreatedDate());
        user.get().setUpdateDate(userDetails.getUpdateDate());
        user.get().setLogin(userDetails.getLogin());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
    }

    //Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long idUser){
        Optional<User> user = userService.findById(idUser);
        if (!user.isPresent()){
            return ResponseEntity.notFound().build();
        }

        userService.deleteById(idUser);
        return ResponseEntity.ok().build();
    }

    // Lee todos los usuarios
    @GetMapping
    public List<User> readAll(){
        List<User> users = StreamSupport
                .stream(userService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return users;
    }
}
