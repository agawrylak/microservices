package agawrylak.credit.wrappers;

import agawrylak.credit.dtos.CreditDTO;
import agawrylak.credit.dtos.CustomerDTO;
import agawrylak.credit.dtos.ProductDTO;
import lombok.*;

@Getter
@Setter
public class DataWrapper {
    CreditDTO creditDTO;
    CustomerDTO customerDTO;
    ProductDTO productDTO;
}
