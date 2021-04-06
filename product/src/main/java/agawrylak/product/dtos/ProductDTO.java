package agawrylak.product.dtos;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String productName;
    private int value;
}
