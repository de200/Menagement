package pl.simpleproject.entity.parser;

import pl.simpleproject.entity.enumtype.Color;


public class ColorParser {

    public static Color parseStringToColor(String str){
        String color = str.toUpperCase();

        if(color.equals("BLACK")){
            return Color.BLACK;
        }
        if(color.equals("WHITE")){
            return Color.WHITE;
        }
        if(color.equals("RED")){
            return Color.RED;
        }
        if(color.equals("GREEN")){
            return Color.GREEN;
        }
        if(color.equals("BLUE")){
            return Color.BLUE;
        }
        if(color.equals("YELLOW")){
            return Color.YELLOW;
        }
        return Color.WHITE;
    }
}
