package imtixon.uz.start_up.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO <T>{
    private boolean succsess;
    private Integer code;
    private String message;
    private T data;
}
