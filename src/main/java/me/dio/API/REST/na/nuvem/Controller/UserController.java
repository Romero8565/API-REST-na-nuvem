package me.dio.API.REST.na.nuvem.Controller;

import me.dio.API.REST.na.nuvem.Service.UserService;
import me.dio.API.REST.na.nuvem.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);

    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate){
        var usercreated = userService.createUser(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usercreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(usercreated);

    }
}
