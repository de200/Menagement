package pl.simpleproject.dao;

import pl.simpleproject.Utils.FileUtils;
import pl.simpleproject.api.ProductDao;
import pl.simpleproject.entity.Product;
import pl.simpleproject.entity.parser.ProductParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoImpl implements ProductDao {

    private static final String fileName = "products.data";

    // singleton
    private ProductDaoImpl() {
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ProductDaoImpl instance = null;

    public static ProductDaoImpl getInstance() {
        if (instance == null) {
            instance = new ProductDaoImpl();
        }
        return instance;
    }


    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    public void saveProducts(List<Product> products) throws IOException {
        FileUtils.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (Product product : products) {
            printWriter.write(product.toString() + "\n");
        }
        printWriter.close();
    }

    public void removeProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                products.remove(product);
            }
        }
        saveProducts(products);
    }

    public void removeProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                products.remove(product);
            }
        }
        saveProducts(products);
    }

    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<Product>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String readLine = reader.readLine();
        while (readLine != null) {
            Product product = ProductParser.stringToProduct(readLine);
            if (product != null) {
                products.add(product);
            }
            readLine = reader.readLine();
        }
        reader.close();
        return products;
    }

}