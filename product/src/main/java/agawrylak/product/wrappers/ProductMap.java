package agawrylak.product.wrappers;

import agawrylak.product.dtos.ProductDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class ProductMap {
    HashMap<Integer, ProductDTO> map;
}
