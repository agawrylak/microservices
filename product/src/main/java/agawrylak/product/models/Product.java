package agawrylak.product.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product",schema="productdb")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "credit_id")
    private Integer creditID;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "value")
    private int value;
}
