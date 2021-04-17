package Ada.APIRest.controller;

import Ada.APIRest.DTO.StudentDTO;
import Ada.APIRest.entity.Rep;
import Ada.APIRest.entity.Student;
import Ada.APIRest.entity.User;
import Ada.APIRest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/User")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public @ResponseBody
    Iterable<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        Optional<User> user = userService.findById(id);

        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

   /* @PostMapping(path = "/newUser")
    public ResponseEntity<User> newUser(@RequestBody User user) {

        User newUser = userService.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }*/
}


