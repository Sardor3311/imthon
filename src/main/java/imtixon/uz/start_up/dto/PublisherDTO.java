package imtixon.uz.start_up.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDTO {
    @NonNull
    private Integer id;
    private String name;
    private AddressDTO addressDTO;
}
