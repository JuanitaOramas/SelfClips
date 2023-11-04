package eci.selfClips.web.controller;

import eci.selfClips.models.user.User;
import eci.selfClips.models.user.UserDto;
import eci.selfClips.services.user.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
class UserController {

    @GetMapping("/user")
    public String createUser(){
        return "<h1>The API is working ok!</h1>";
    }





    private final UsersService usersService;

    public UserController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User userCreated= usersService.save(new User(userDto));
        URI createdUserUri = URI.create("/v1/users/"+ userCreated.getId());
        return ResponseEntity.created(createdUserUri).body(userCreated);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        return ResponseEntity.ok(usersService.all());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        //TODO implement this method
        Optional<User> user = usersService.findById(id);

            return ResponseEntity.ok(user.get());


    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody UserDto userDto) {
        Optional<User> user = usersService.findById(id);

        usersService.update(new User(userDto),id);
        return ResponseEntity.ok(usersService.save(user.get()));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        Optional<User> user = usersService.findById(id);

            usersService.deleteById(id);
            return ResponseEntity.ok().build();


    }
}
