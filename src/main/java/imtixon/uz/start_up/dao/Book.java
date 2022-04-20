package imtixon.uz.start_up.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(generator = "book_id_seq")
    @SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name_uz_ly")
    private String name_uz_ly;

    @Column(name = "name_uz_cyr")
    private String name_uz_cry;

    @Column(name = "name_ru")
    private String name_ru;

    @Column(name = "name_eng")
    private String name_eng;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "published_date")
    private Date published_date;

    @Column(name = "authorid")
    private Integer authorId;

    @Column(name = "pages_count")
    private Integer pages_count;

    @Column(name = "genre")
    private String genre;

    @Column(name = "pablisherid")
    private Integer pablisherId;

    @Column(name = "cost_page")
    private BigDecimal cost_page;

    public Book(Integer id, String name_uz_ly, BigDecimal cost, Integer authorId, String genre, Integer publisherId) {
        this.id = id;
        this.name_uz_ly = name_uz_ly;
        this.cost = cost;
        this.authorId = authorId;
        this.genre = genre;
        this.pablisherId = publisherId;
    }


}
