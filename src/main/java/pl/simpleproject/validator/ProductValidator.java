package pl.simpleproject.validator;

import pl.simpleproject.entity.Product;
import pl.simpleproject.exception.ProductCountNegativeException;
import pl.simpleproject.exception.ProductNameEmptyException;
import pl.simpleproject.exception.ProductPriceNoPositiveException;
import pl.simpleproject.exception.ProductWeightNoPositiveException;

public class ProductValidator {

    // singleton
    private ProductValidator() {
    }

    public static ProductValidator instance = null;

    public static ProductValidator getInstance() {
        if (instance == null) {
            instance = new ProductValidator();
        }
        return instance;
    }

    public boolean isValidate(Product product) throws ProductCountNegativeException, ProductNameEmptyException, ProductPriceNoPositiveException, ProductWeightNoPositiveException {
        if(isProductNumberNegative(product.getProductNumber())){
            throw new ProductCountNegativeException("Product count number can not be negative");
        }
        if(isProductNameEmptySpace(product.getProductName())) {
            throw new ProductNameEmptyException("Product name can not empty");
        }
        if(isProductPriceNegative(product.getProductPrice())) {
            throw new ProductPriceNoPositiveException("Product price can not less or equal 0");
        }
        if(isProductWeightNegative(product.getProductWeight())) {
            throw new ProductWeightNoPositiveException("Product weight can not be less or equal 0");
        }
        return true;
    }

    private boolean isProductNumberNegative(Integer  productNumber){
        return productNumber < 0;
    }

    private boolean isProductNameEmptySpace(String productName){
        return productName.length() == 0;
    }

    private boolean isProductPriceNegative(Float productPrice){
        return productPrice <= 0f;
    }

    private boolean isProductWeightNegative(Float productWeight){
        return productWeight <= 0f;
    }
}
