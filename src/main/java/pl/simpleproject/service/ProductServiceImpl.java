package pl.simpleproject.service;

import pl.simpleproject.api.ProductDao;
import pl.simpleproject.api.ProductService;
import pl.simpleproject.dao.ProductDaoImpl;
import pl.simpleproject.entity.Product;
import pl.simpleproject.validator.ProductValidator;


import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    // singleton
    private static ProductServiceImpl instance = null;

    private ProductServiceImpl() {
    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    ProductDao productDao = ProductDaoImpl.getInstance();
    ProductValidator productValidator = ProductValidator.getInstance();

    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    public Integer getProductsNumber() throws IOException {
        return productDao.getAllProducts().size();
    }

    public Product getProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            boolean isProductNameFound = product.getProductName().equals(productName);
            if (isProductNameFound) {
                return product;
            }
        }
        return null;
    }

    public Product getProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public boolean isProductExist(String productName) {
        Product product = null;
        try {
            product = getProductByName(productName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (product == null) {
            return false;
        }
        return true;
    }

    public boolean isProductExist(Long productId) {
        Product product = null;
        try {
            product = getProductById(productId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (product == null) {
            return false;
        }
        return true;
    }

    public boolean isProductAvailable(String productName) {
        try {
            for (Product product : getAllProducts()) {
                if (isProductExist(productName) && product.getProductNumber() > 0) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveProduct(Product product) {
        try {
            boolean validProduct = productValidator.isValidate(product);
            if (validProduct) {
                productDao.saveProduct(product);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
