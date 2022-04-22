package imtixon.uz.start_up.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pablisher")
@Data

public class Publisher {
    @Id
    @GeneratedValue(generator = "pablisher_id_seq")
    @SequenceGenerator(name = "pablisher_id_seq", sequenceName = "publisher_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressid")
    private Address adress;
}
