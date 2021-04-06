package agawrylak.credit.wrappers;

import agawrylak.credit.dtos.CreditDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class CreditMap {
    private HashMap<Integer, CreditDTO> map;
}
