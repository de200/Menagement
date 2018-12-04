package pl.simpleproject.entity.parser;

import pl.simpleproject.entity.enumtype.SkinType;

public class SkinTypeParser {

    public static SkinType parseStringToSkinType(String str){
        String skinType = str.toUpperCase();

        if(skinType.equals("NATURAL")){
            return SkinType.NATURAL;
        }
        if(skinType.equals("ARTIFICIAL")){
            return SkinType.ARTIFICIAL;
        }
        return SkinType.ARTIFICIAL;
    }
}
