package pl.simpleproject.api;

import pl.simpleproject.entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws IOException;

    Integer getProductsNumber() throws IOException;

    Product getProductByName(String productName) throws IOException;

    Product getProductById(Long productId) throws IOException;

    boolean isProductAvailable(String productName);

    boolean isProductExist(String productName);

    boolean isProductExist(Long productId);

    boolean saveProduct(Product product);
}
