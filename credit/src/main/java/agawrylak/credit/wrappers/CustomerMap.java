package agawrylak.credit.wrappers;

import agawrylak.credit.dtos.CustomerDTO;
import lombok.Getter;

import java.util.HashMap;

@Getter
public class CustomerMap {
    private HashMap<Integer, CustomerDTO> map;
}
