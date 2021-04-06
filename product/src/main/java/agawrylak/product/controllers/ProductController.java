package agawrylak.product.controllers;

import agawrylak.product.dtos.ProductDTO;
import agawrylak.product.services.ProductService;
import agawrylak.product.wrappers.ProductMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product/add/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void addProduct(@RequestBody final ProductDTO productDTO, @PathVariable final int id) {
        productService.add(productDTO, id);
    }

    @PostMapping("/product/get")
    public ProductMap getProducts(@RequestBody List<Integer> idList) {
        return productService.findProductsByIds(idList);
    }

}
