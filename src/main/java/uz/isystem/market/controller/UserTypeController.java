package uz.isystem.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.market.model.UserType;
import uz.isystem.market.service.UserTypeServise;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/user-type")
public class UserTypeController {
    @Autowired
    private UserTypeServise userTypeServise;

    @GetMapping("/id")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        UserType result = userTypeServise.get(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam("name") String name){
        List<UserType> result = userTypeServise.getByName(name);
        if(result == null){
            return ResponseEntity.badRequest().body("user name is not found");
        }
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserType name){
        Boolean result = userTypeServise.create(name);
        return ResponseEntity.ok("User type created");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Integer id, @RequestBody UserType  userType){
        return ResponseEntity.ok(userTypeServise.update(id, userType));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Integer id){
        userTypeServise.delete(id);
        return  ResponseEntity.ok("user type delete");
    }


}
