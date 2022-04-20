package imtixon.uz.start_up.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Integer id;
    private String name;
    private String author;
    private BigDecimal cost;
    private String genre;
    private Integer publisherId;

    public String toString(){
        return String.format("%d-kitob: \nNomi: %s \nNarxi: %.2f \nJanri: %s \nMuallif: %s", id, name, cost, genre, author);
    }
}
