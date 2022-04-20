package imtixon.uz.start_up.service.validete;

import imtixon.uz.start_up.dao.User;
import imtixon.uz.start_up.dto.ResponseDTO;
import imtixon.uz.start_up.dto.UserDTO;
import imtixon.uz.start_up.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ValidateUserData {

    private final UserRepository userRepository;

    public ResponseDTO<UserDTO> validateUser(UserDTO userDTO){
        Optional<User> user = Optional.ofNullable(userRepository.findByUserName(userDTO.getUserName()));

        if(user.isPresent() && userDTO.getId() != user.get().getId()){
            return new ResponseDTO<>(false, -1, "this userName is available", userDTO);
        }
        else if(userDTO.getUserName() == null){
            return new ResponseDTO<>(false, -2, "userName should not be null", userDTO);
        }
        return new ResponseDTO<>(true, 0, "OK", userDTO);
    }
}
