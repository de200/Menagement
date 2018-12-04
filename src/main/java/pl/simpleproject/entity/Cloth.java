package pl.simpleproject.entity;

import pl.simpleproject.entity.enumtype.Color;
import pl.simpleproject.entity.enumtype.Material;
import pl.simpleproject.entity.enumtype.Separators;

import java.util.Objects;

public class Cloth extends Product {

    private String clothSize;
    private Material material;

    public Cloth(Long productId, String productName, Float productPrice, Float productWeight, Color productColor, Integer productNumber, String clothSize, Material material) {
        super(productId, productName, productPrice, productWeight, productColor, productNumber);
        this.clothSize = clothSize;
        this.material = material;
    }

    public String getClothSize() {
        return clothSize;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cloth)) return false;
        if (!super.equals(o)) return false;
        Cloth cloth = (Cloth) o;
        return Objects.equals(getClothSize(), cloth.getClothSize()) &&
                getMaterial() == cloth.getMaterial();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getClothSize(), getMaterial());
    }

    @Override
    public String toString() {
        return Separators.BOOTS_ID.toString() + Separators.SEPARATOR.toString() + getProductElements() + Separators.SEPARATOR.toString() + clothSize + Separators.SEPARATOR.toString() + material;
    }
}
