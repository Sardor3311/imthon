package imtixon.uz.start_up.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String phone_number;
    private BigDecimal account;
    private String userName;
}
