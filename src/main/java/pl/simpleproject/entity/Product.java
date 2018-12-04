package pl.simpleproject.entity;

import pl.simpleproject.entity.enumtype.Color;
import pl.simpleproject.entity.enumtype.Separators;

import java.util.Objects;

public class Product {

    private Long productId;
    private String productName;
    private Float productPrice;
    private Float productWeight;
    private Color color;
    private Integer productNumber;

    public Product(Long productId, String productName, Float productPrice, Float productWeight, Color color, Integer productNumber) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productWeight = productWeight;
        this.color = color;
        this.productNumber = productNumber;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public Float getProductWeight() {
        return productWeight;
    }

    public Color getColor() {
        return color;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getProductId(), product.getProductId()) &&
                Objects.equals(getProductName(), product.getProductName()) &&
                Objects.equals(getProductPrice(), product.getProductPrice()) &&
                Objects.equals(getProductWeight(), product.getProductWeight()) &&
                getColor() == product.getColor() &&
                Objects.equals(getProductNumber(), product.getProductNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getProductPrice(), getProductWeight(), getColor(), getProductNumber());
    }

    public String getProductElements() {
        return productId + Separators.SEPARATOR.toString() + productName + Separators.SEPARATOR.toString() + productPrice + Separators.SEPARATOR.toString() + productWeight + Separators.SEPARATOR.toString() + color + Separators.SEPARATOR.toString() + productNumber;
    }

    @Override
    public String toString() {
        return Separators.PRODUCT_ID + Separators.SEPARATOR.toString() + getProductElements();
    }
}