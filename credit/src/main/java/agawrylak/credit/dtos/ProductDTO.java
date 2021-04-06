package agawrylak.credit.dtos;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private String productName;
    private int value;
}
