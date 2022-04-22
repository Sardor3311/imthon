package imtixon.uz.start_up.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(generator = "address_id_seq")
    @SequenceGenerator(name = "address_id_seq", sequenceName = "address_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "regionid")
    private Integer region_id;

    @Column(name = "districtid")
    private Integer district_id;

    @Column(name = "street")
    private String street;

    @Column(name = "homenumber")
    private String homeNumber;

    @Column(name = "orient")
    private String orient;
}
