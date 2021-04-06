package agawrylak.customer.wrappers;

import agawrylak.customer.dtos.CustomerDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;


@Getter
@Setter
public class CustomerMap {
    private HashMap<Integer, CustomerDTO> map;
}
