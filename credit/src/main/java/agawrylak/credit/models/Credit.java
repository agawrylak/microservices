package agawrylak.credit.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "credit")
@Getter
@Setter
@EqualsAndHashCode
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private int id;

    @Column(name = "credit_name")
    private String creditName;
}
