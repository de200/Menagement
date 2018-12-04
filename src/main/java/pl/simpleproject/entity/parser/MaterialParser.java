package pl.simpleproject.entity.parser;

import pl.simpleproject.entity.enumtype.Material;

public class MaterialParser {

    public static Material parseStringToMaterial(String str){
        String material = str.toUpperCase();

        if(material.equals("LEATHER")){
            return Material.LEATHER;
        }
        if(material.equals("FUR")){
            return Material.FUR;
        }
        if(material.equals("COTTON")){
            return Material.COTTON;
        }
        if(material.equals("WOOL")){
            return Material.WOOL;
        }
        if(material.equals("POLYESTER")){
            return Material.POLYESTER;
        }
        return Material.POLYESTER;
    }
}
