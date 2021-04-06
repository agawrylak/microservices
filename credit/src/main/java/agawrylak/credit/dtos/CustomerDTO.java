package agawrylak.credit.dtos;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private String firstName;
    private long peselNumber;
    private String surname;
}
