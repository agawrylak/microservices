package agawrylak.product.services;

import agawrylak.product.dtos.ProductDTO;
import agawrylak.product.models.Product;
import agawrylak.product.repositories.ProductRepository;
import agawrylak.product.wrappers.ProductMap;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductService {

    final ProductRepository productRepository;
    private ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDTO add(ProductDTO product, Integer id){
        return convertToDTO(productRepository.save(convertToEntity(product, id)));
    }

    public ProductMap findProductsByIds(List<Integer> idList){
        List<Product> foundProducts = productRepository.findByCreditIDIn(idList);
        HashMap<Integer, ProductDTO> resultMap = new HashMap<>();
        for(Product product : foundProducts){
            resultMap.put(product.getCreditID(),convertToDTO(product));
        }
        ProductMap productMap = new ProductMap();
        productMap.setMap(resultMap);
        return productMap;
    }

    private Product convertToEntity(ProductDTO productDTO, Integer id) {
        Product product = modelMapper.map(productDTO, Product.class);
        product.setCreditID(id);
        return product;
    }

    private ProductDTO convertToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

}
