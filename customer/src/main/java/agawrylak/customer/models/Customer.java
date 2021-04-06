package agawrylak.customer.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer", schema="customerdb")
@Getter
@Setter
@EqualsAndHashCode
public class Customer {

    @Id
    @Column(name = "credit_id")
    private Integer creditID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "pesel")
    private long peselNumber;

    @Column(name = "surname")
    private String surname;

}
