package agawrylak.customer.dtos;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String firstName;
    private long peselNumber;
    private String surname;
}
