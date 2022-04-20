package imtixon.uz.start_up.service;

import imtixon.uz.start_up.dao.User;
import imtixon.uz.start_up.dto.ResponseDTO;
import imtixon.uz.start_up.dto.UserDTO;
import imtixon.uz.start_up.mapping.UserMapping;
import imtixon.uz.start_up.repository.UserRepository;
import imtixon.uz.start_up.service.validete.ValidateUserData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ValidateUserData validateUserData;

    public ResponseDTO<List<UserDTO>> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (!users.isEmpty()){
            List<UserDTO> result = new ArrayList<>();
            for (User user : users){
                result.add(UserMapping.toUserDTO(user));
            }
            return new ResponseDTO<>(true,1,"All users list", result);
        }
        return new ResponseDTO<>(false, -1, "Data not found", null);
    }

    public ResponseDTO<UserDTO> getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            UserDTO userDTO = UserMapping.toUserDTO(user.get()) ;
            return new ResponseDTO<UserDTO>(true,1,"ok",userDTO);
        }
        return new ResponseDTO<>(false, -1, "not found user",null);
    }

    public ResponseDTO<UserDTO> addUser(UserDTO userDTO) {
       ResponseDTO responseDTO = validateUserData.validateUser(userDTO);
       User user = new User();
       if (responseDTO.getCode() == 0) {
           try {
               user = UserMapping.toUserEntity(userDTO);
               userRepository.save(user);
               return new ResponseDTO<UserDTO>(true, 1, "success", UserMapping.toUserDTO(user));
           }catch (Exception e){
               e.printStackTrace();
               return new ResponseDTO<>(false, -1, "Error saving", null);
           }
       }
       return responseDTO;
    }

    public ResponseDTO<UserDTO> updateUser(UserDTO userDTO) {
        Optional<User> user = userRepository.findById(userDTO.getId());
        if (user.isPresent()){
            ResponseDTO responseDTO = validateUserData.validateUser(userDTO);
            if (responseDTO.getCode() == 0){
               try {
                   User user1 = UserMapping.toUserEntity(userDTO);
                   userRepository.save(user1);
                   return new ResponseDTO<>(true, 1, "Updated", userDTO);
               }catch (Exception e){
                   e.printStackTrace();
                   return new ResponseDTO<>(false, -6, "ERROR updating", userDTO);
               }
            }
            return responseDTO;
        }
        return new ResponseDTO<>(false,-1,"not found user", userDTO);
    }
}
