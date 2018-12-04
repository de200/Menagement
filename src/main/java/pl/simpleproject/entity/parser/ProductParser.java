package pl.simpleproject.entity.parser;

import pl.simpleproject.entity.Boots;
import pl.simpleproject.entity.Cloth;
import pl.simpleproject.entity.enumtype.Color;
import pl.simpleproject.entity.enumtype.Material;
import pl.simpleproject.entity.enumtype.Separators;
import pl.simpleproject.entity.enumtype.SkinType;
import pl.simpleproject.entity.Product;

public class ProductParser {



    public static Product stringToProduct(String productString) {
        Separators separators = Separators.getIdByChar(productString.substring(0,1));

        switch (separators) {
            case PRODUCT_ID:
                return convertToProduct(productString);

            case CLOTH_ID:
                return convertToCloth(productString);

            case BOOTS_ID:
                return convertToBoots(productString);
        }
        return null;
    }

    private static Product convertToProduct(String productString) {
        String[] productInformation = productString.split(Separators.SEPARATOR.toString());

        Long productId = Long.parseLong(productInformation[1]);
        String productName = productInformation[2];
        Float productPrice = Float.parseFloat(productInformation[3]);
        Float productWeight = Float.parseFloat(productInformation[4]);
        Color productColor = ColorParser.parseStringToColor(productInformation[5]);
        Integer productNumber = Integer.parseInt(productInformation[6]);

        return new Product(productId, productName, productPrice, productWeight, productColor, productNumber);
    }

    private static Boots convertToBoots(String productString) {
        String[] productInformation = productString.split(Separators.SEPARATOR.toString());

        Long productId = Long.parseLong(productInformation[1]);
        String productName = productInformation[2];
        Float productPrice = Float.parseFloat(productInformation[3]);
        Float productWeight = Float.parseFloat(productInformation[4]);
        Color productColor = ColorParser.parseStringToColor(productInformation[5]);
        Integer productNumber = Integer.parseInt(productInformation[6]);
        Integer bootSize = Integer.parseInt(productInformation[7]);
        SkinType skinType = SkinTypeParser.parseStringToSkinType(productInformation[8]);

        return new Boots(productId, productName, productPrice, productWeight, productColor, productNumber, bootSize, skinType);
    }

    private static Cloth convertToCloth(String productString) {
        String[] productInformation = productString.split(Separators.SEPARATOR.toString());

        Long productId = Long.parseLong(productInformation[1]);
        String productName = productInformation[2];
        Float productPrice = Float.parseFloat(productInformation[3]);
        Float productWeight = Float.parseFloat(productInformation[4]);
        Color productColor = ColorParser.parseStringToColor(productInformation[5]);
        Integer productNumber = Integer.parseInt(productInformation[6]);
        String clothSize = productInformation[7];
        Material clothMaterial = MaterialParser.parseStringToMaterial(productInformation[8]);

        return new Cloth(productId, productName, productPrice, productWeight, productColor, productNumber, clothSize, clothMaterial);
    }
}


