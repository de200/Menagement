package parser;

import org.junit.Assert;
import org.junit.Test;
import pl.simpleproject.entity.enumtype.Material;
import pl.simpleproject.entity.parser.MaterialParser;

public class MaterialParserTest {

    @Test
    public void materialParserLeather(){
        String materialString = "LeaTHer";

        Material material = MaterialParser.parseStringToMaterial(materialString);

        Assert.assertEquals(Material.LEATHER,material);
    }

    @Test
    public void testMaterialParserFur(){
        String materialString = "FUr";

        Material material = MaterialParser.parseStringToMaterial(materialString);

        Assert.assertEquals(Material.FUR,material);
    }

    @Test
    public void testMaterialParserCotton(){
        String materialString = "coTTon";

        Material material = MaterialParser.parseStringToMaterial(materialString);

        Assert.assertEquals(Material.COTTON,material);
    }

    @Test
    public void testMaterialParserWool(){
        String materialString = "wOOl";

        Material material = MaterialParser.parseStringToMaterial(materialString);

        Assert.assertEquals(Material.WOOL,material);
    }

    @Test
    public void testMaterialParserPolyester(){
        String materialString = "PoLyesteR";

        Material material = MaterialParser.parseStringToMaterial(materialString);

        Assert.assertEquals(Material.POLYESTER,material);
    }

    @Test
    public void testMaterialParserWrongMaterial(){
        String materialString = "wrongMaterial";

        Material material = MaterialParser.parseStringToMaterial(materialString);

        Assert.assertEquals(Material.POLYESTER,material);
    }
}
