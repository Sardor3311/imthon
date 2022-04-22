package imtixon.uz.start_up.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Integer id;
    private Integer region_id;
    private Integer district_id;
    private String street;
    private String homeNumber;
    private String orient;
}
