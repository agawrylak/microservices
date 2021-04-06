package agawrylak.credit.wrappers;

import agawrylak.credit.dtos.ProductDTO;
import lombok.Getter;

import java.util.HashMap;

@Getter
public class ProductMap {
    HashMap<Integer, ProductDTO> map;
}
