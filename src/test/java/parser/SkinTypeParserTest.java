package parser;

import org.junit.Assert;
import org.junit.Test;
import pl.simpleproject.entity.enumtype.SkinType;
import pl.simpleproject.entity.parser.SkinTypeParser;

public class SkinTypeParserTest {

    @Test
    public void testSkinTypeParserNatural(){
        String skinTypeString = "naTuraL";

        SkinType skinType = SkinTypeParser.parseStringToSkinType(skinTypeString);

        Assert.assertEquals(SkinType.NATURAL, skinType);
    }

    @Test
    public void testSkinTypeParserArtifficial(){
        String skinTypeString = "artiFiciaL";

        SkinType skinType = SkinTypeParser.parseStringToSkinType(skinTypeString);

        Assert.assertEquals(SkinType.ARTIFICIAL, skinType);
    }

    @Test
    public void testSkinTypeParserWrongType(){
        String skinTypeString = "wrongType";

        SkinType skinType = SkinTypeParser.parseStringToSkinType(skinTypeString);

        Assert.assertEquals(SkinType.ARTIFICIAL, skinType);
    }





}
