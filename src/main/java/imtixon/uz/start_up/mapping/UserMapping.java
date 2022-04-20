package imtixon.uz.start_up.mapping;

import imtixon.uz.start_up.dao.User;
import imtixon.uz.start_up.dto.UserDTO;

public class UserMapping {

    public static UserDTO toUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate(),
                user.getPhone_number(),
                user.getAccount(),
                user.getUserName()
        );
    }

    public static User toUserEntity(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getBirthdate(),
                userDTO.getPhone_number(),
                userDTO.getAccount(),
                userDTO.getUserName()
        );
    }
}
