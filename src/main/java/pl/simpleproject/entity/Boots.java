package pl.simpleproject.entity;




import pl.simpleproject.entity.enumtype.Color;
import pl.simpleproject.entity.enumtype.Separators;
import pl.simpleproject.entity.enumtype.SkinType;

import java.util.Objects;

public class Boots extends Product {

    private Integer bootSize;
    private SkinType skinType;

    public Boots(Long productId, String productName, Float productPrice, Float productWeight, Color productColor, Integer productNumber, Integer bootSize, SkinType skinType) {
        super(productId, productName, productPrice, productWeight, productColor, productNumber);
        this.bootSize = bootSize;
        this.skinType = skinType;
    }

    public Integer getBootSize() {
        return bootSize;
    }

    public SkinType getSkinType() {
        return skinType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boots)) return false;
        if (!super.equals(o)) return false;
        Boots boots = (Boots) o;
        return Objects.equals(getBootSize(), boots.getBootSize()) &&
                getSkinType() == boots.getSkinType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBootSize(), getSkinType());
    }

    @Override
    public String toString() {
        return Separators.BOOTS_ID.toString() + Separators.SEPARATOR.toString() + getProductElements() + Separators.SEPARATOR.toString() +  bootSize + Separators.SEPARATOR.toString() + skinType;
    }
}
