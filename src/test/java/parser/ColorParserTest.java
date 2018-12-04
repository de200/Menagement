package parser;

import org.junit.Assert;
import org.junit.Test;
import pl.simpleproject.entity.enumtype.Color;
import pl.simpleproject.entity.parser.ColorParser;

public class ColorParserTest {

    @Test
    public void testColorParserBlue(){
        String stringColor = "bLuE";

        Color color = ColorParser.parseStringToColor(stringColor);

        Assert.assertEquals(Color.BLUE, color);
    }

    @Test
    public void testColorParserRed(){
        String stringColor = "Red";

        Color color = ColorParser.parseStringToColor(stringColor);

        Assert.assertEquals(Color.RED, color);
    }

    @Test
    public void testColorParserBlack(){
        String stringColor = "bLaCK";

        Color color = ColorParser.parseStringToColor(stringColor);

        Assert.assertEquals(Color.BLACK, color);
    }

    @Test
    public void testColorParserWhite(){
        String stringColor = "White";

        Color color = ColorParser.parseStringToColor(stringColor);

        Assert.assertEquals(Color.WHITE, color);
    }

    @Test
    public void testColorParserGreen(){
        String stringColor = "greeN";

        Color color = ColorParser.parseStringToColor(stringColor);

        Assert.assertEquals(Color.GREEN, color);
    }

    @Test
    public void testColorParserYellow(){
        String stringColor = "YeLLOW";

        Color color = ColorParser.parseStringToColor(stringColor);

        Assert.assertEquals(Color.YELLOW, color);
    }

    @Test
    public void testColorParserWrongColor(){
        String stringColor = "wrongColor";

        Color color = ColorParser.parseStringToColor(stringColor);

        Assert.assertEquals(Color.WHITE, color);
    }
}
