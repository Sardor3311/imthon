package imtixon.uz.start_up.rest;

import imtixon.uz.start_up.dto.ResponseDTO;
import imtixon.uz.start_up.dto.UserDTO;
import imtixon.uz.start_up.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping("/get-all-user")
    public ResponseDTO<List<UserDTO>> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get-by/{id}")
    public ResponseDTO<UserDTO> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping("/add-user")
    public ResponseDTO<UserDTO> addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @PutMapping("/update-user")
    public ResponseDTO<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }
}
