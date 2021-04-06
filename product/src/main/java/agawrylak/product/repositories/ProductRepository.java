package agawrylak.product.repositories;

import agawrylak.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCreditIDIn(List<Integer> id);
}
