package lk.ijse.easybodimak_backend.controller;

import lk.ijse.easybodimak_backend.dto.UserDTO;
import lk.ijse.easybodimak_backend.dto.UserLoginDto;
import lk.ijse.easybodimak_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    @PostMapping
    public String test() {
        return "test working";
    }

    @PutMapping
    public void saveUser(@RequestBody UserDTO userDTO) {
        System.out.println("saveUser()");
        System.out.println(userDTO.getAddress());



        userService.saveUser(userDTO);
    }

    @PostMapping("/{id}")
    public void updateUser(@PathVariable("id") String id,
                         @RequestBody UserDTO userDTO) {
        userService.updateUser(id, userDTO);
    }



    @GetMapping
    public Object findAllUsers(@RequestParam(value = "action", required = false) String action
            , @RequestParam(value = "name", required = false) String name) {
        if (action != null) {
            switch (action) {
                case "count":
                    return userService.getUsersCount();
                case "like":
//                    return userService.findUsersLike(name);
                default:
                    return userService.getAllUsers();
            }
        } else {
            return userService.getAllUsers();
        }
    }

    @GetMapping("/{id}")
    public UserDTO findUser(@PathVariable("id") String id){

        System.out.println(id);
        return userService.findUser(id);
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody UserLoginDto userLoginDto) {

        List<UserDTO> allUsers = userService.getAllUsers();
        String userId = null;
        for (UserDTO userDTO : allUsers) {
            if (userDTO.getEmail().equals(userLoginDto.getEmail())) {

                if (userDTO.getPassword().equals(userLoginDto.getPassword())) {

                    userId = userDTO.getId();

                } else {

                }
            }
        }

        return userId;
    }
}

